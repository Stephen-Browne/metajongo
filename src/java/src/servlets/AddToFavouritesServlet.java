/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "AddToFavouritesServlet", urlPatterns = {"/AddToFavouritesServlet"})
public class AddToFavouritesServlet extends HttpServlet {

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
        
        int propertyForFavourite = Integer.parseInt(request.getParameter("propertyId"));
        
        Cookie[] cookies = request.getCookies();
        
        // Separate cookie for each favourite
        
        
        for(Cookie c:cookies){

            if(c.getValue() == Integer.toString(propertyForFavourite)){
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPropertyServlet");
                
                dispatcher.forward(request, response);
                
            }
            
        }
       
            
            Cookie myFavouritesCookie = new Cookie("aFavouriteProperty_" + Integer.toString(propertyForFavourite), Integer.toString(propertyForFavourite));
            
            myFavouritesCookie.setMaxAge(60 * 24 * 3600);  // Don't want this cookie to expire so set to some date far in the future...
         
            response.addCookie(myFavouritesCookie);
            
            request.setAttribute("propertyid", propertyForFavourite);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            
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
