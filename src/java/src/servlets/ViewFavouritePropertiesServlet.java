/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.PropertiesDatabaseAccess;
import src.entities.Properties;

/**
 *
 * @author Stephen
 */
public class ViewFavouritePropertiesServlet extends HttpServlet {

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
        
        
        
        Cookie[] cookies = request.getCookies();
        
        // Separate cookie for each favourite 
        
        List<Properties> favouritesToDisplay = new ArrayList<>();
        
        for(Cookie c:cookies){
            
            if(c.getName().contains("aFavouriteProperty_") && c.getMaxAge() != 0){
            
            String propertyId = c.getValue();
            
            int propertyIdAsInt = Integer.parseInt(propertyId);
            
            Properties thisProperty = PropertiesDatabaseAccess.getPropertyWithID(propertyIdAsInt);
            
            favouritesToDisplay.add(thisProperty);
        }
            else{
                continue;
            }
            
        }
        
        if(favouritesToDisplay.isEmpty()){ // User has no favourites
           
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("NoFavourites.jsp"); // Reuse the same jsp as is used for searching
        
            dispatcher.forward(request, response);
            
            
            
        }
        
        else{ // User has some favourites
        request.setAttribute("PropertyList", favouritesToDisplay);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProperties.jsp"); // Reuse the same jsp as is used for searching
        
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
