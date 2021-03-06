/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.entities.Properties;
import src.db.PropertiesDatabaseAccess;
import src.entities.Images;

/**
 *
 * @author Stephen
 */
public class ViewPropertyServlet extends HttpServlet {

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
        
        // Get Property Object forwarded from previous page, forward it to drill down page.
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProperty.jsp");
        
        String id = request.getParameter("propertyid");
        
        int propertyid = Integer.parseInt(id);
        
        Properties propertyFromDB = new Properties();
        
        propertyFromDB = PropertiesDatabaseAccess.getPropertyWithID(propertyid);
        
        Collection<Images> images = propertyFromDB.getImagesCollection();
        
          
        if(propertyFromDB != null){
            
            if(isAlreadyInFavourites(request, id)){
                
                request.setAttribute("showFavouriteButton", false);
                
            }else{
                
                request.setAttribute("showFavouriteButton", true);
            }
       
            propertyFromDB.setViews(propertyFromDB.getViews() + 1); // Update the view count for this property
            
            PropertiesDatabaseAccess.updateProperty(propertyFromDB);
            
            request.setAttribute("property", propertyFromDB);
         
            dispatcher.forward(request, response);
            
        }
        
        else{
            dispatcher = request.getRequestDispatcher("error.jsp");
            
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
    
    public boolean isAlreadyInFavourites(HttpServletRequest request, String propertyId){
        
           Cookie[] cookies = request.getCookies();
        
        // Separate cookie for each favourite
        
        String valueToCheck = "favouriteProperty_" + propertyId; 
        
        
        for(Cookie c:cookies){
            
            if(c.getName().contains("aFavouriteProperty_")){


                    if(c.getValue().equals(propertyId) ){

                       return true;

                    }
            
            }
            
        }
        
        return false;
        
        
        
    }

}
