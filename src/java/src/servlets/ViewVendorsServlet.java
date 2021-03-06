/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import src.db.VendorDatabaseAccess;
import src.entities.Agents;
import src.entities.Vendors;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "ViewVendorsServlet", urlPatterns = {"/ViewVendorsServlet"})
public class ViewVendorsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Subject currentUser = SecurityUtils.getSubject();
        
        Session session = currentUser.getSession();
        
        Agents thisAgent = (Agents)session.getAttribute("currentAgent");
        
        Collection<Vendors> vendorsForCurrentAgent = thisAgent.getVendorsCollection();
        
        if(vendorsForCurrentAgent.isEmpty()){
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("nothingToDisplay.jsp");
            
            dispatcher.forward(request, response);

            
        }
        
        else{
            
            request.setAttribute("vendors", vendorsForCurrentAgent);
               
            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewVendors.jsp");
            
            dispatcher.forward(request, response);
            
        }
        
        
        
        
        
       
        
        
        
     
        
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
