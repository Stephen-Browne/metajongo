/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class AddVendorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        Subject currentUser = SecurityUtils.getSubject();
        
        Session session = currentUser.getSession();

        String vendorName = request.getParameter("vendorName"); // TODO: come back and do null checking here and send to error page
        
        Vendors v = new Vendors();
        
        Agents loggedInAgent = (Agents)session.getAttribute("currentAgent");
        
                
        
        v.setAgentsagentId(loggedInAgent);
        v.setName(vendorName);
   
        
        String nextPage = "error.jsp";
     
        boolean operationSuccessful = VendorDatabaseAccess.addVendor(v); // Add this vendor to the Database
        
        loggedInAgent.getVendorsCollection().add(v);
        
        session.setAttribute("currentAgent", loggedInAgent);
        
        if(operationSuccessful){
            nextPage = "success.jsp";
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
        
      
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
