/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.GarageTypesDatabaseAccess;
import src.db.PropertiesDatabaseAccess;
import src.db.PropertyTypesDatabaseAccess;
import src.db.StylesDatabaseAccess;
import src.entities.Garagetypes;
import src.entities.Images;
import src.entities.Propertytypes;
import src.entities.Styles;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "PrepareForAddPropertyServlet", urlPatterns = {"/PrepareForAddPropertyServlet"})
public class PrepareForAddPropertyServlet extends HttpServlet {

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
        
        // Need collection of Propertytypes Object to pass to request to fill the dropdown on the nextpage
        // Need collection of Garagetypes Objects
        // Need collection of Styles Objects
        
        List<Propertytypes> allPropertyTypes = PropertyTypesDatabaseAccess.GetAllPropertyTypes(); // Get the List of Property type objs

        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProperty.jsp"); // Forward here when ready
        
        request.setAttribute("PropertyTypeList", allPropertyTypes);
        
        List<Garagetypes> allGarageTypes = GarageTypesDatabaseAccess.GetAllGarageTypes(); // Get List of GarageType Objs
        
        request.setAttribute("GarageTypeList", allGarageTypes);
        
        List<Styles> allStyleTypes = StylesDatabaseAccess.GetAllStyleTypes(); // Get list of Style Objs
        
        request.setAttribute("StyleTypeList", allStyleTypes); // Attach these to the request
        
        dispatcher.forward(request, response); // Go to the insertion page
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
