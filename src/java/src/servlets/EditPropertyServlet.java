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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.GarageTypesDatabaseAccess;
import src.db.PropertiesDatabaseAccess;
import src.db.PropertyTypesDatabaseAccess;
import src.db.StylesDatabaseAccess;
import src.db.VendorDatabaseAccess;
import src.entities.Garagetypes;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.Styles;
import src.entities.Vendors;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "EditPropertyServlet", urlPatterns = {"/EditPropertyServlet"})
public class EditPropertyServlet extends HttpServlet {

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
       
        // Get posted values.
        
        int propertyId = Integer.parseInt(request.getParameter("propertyId"));
                
        String street = request.getParameter("street");
        String county = request.getParameter("county");
        int numberOfBedrooms = Integer.parseInt(request.getParameter("numberofbedrooms"));
        double numberOfBathrooms = Double.parseDouble(request.getParameter("numberofbathrooms"));
        int squareFeet = Integer.parseInt(request.getParameter("squarefeet"));
        String lotSize = request.getParameter("lotsize");
        String berRating = request.getParameter("ber");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
     
        Properties propertyToEdit = PropertiesDatabaseAccess.getPropertyWithID(propertyId);
        
        propertyToEdit.setBathrooms(numberOfBathrooms);
        propertyToEdit.setBedrooms(numberOfBedrooms);
        propertyToEdit.setBerRating(berRating);
        propertyToEdit.setPrice(price);
        propertyToEdit.setCity(county);
        propertyToEdit.setStreet(street);
        propertyToEdit.setSquarefeet(squareFeet);
        propertyToEdit.setLotsize(lotSize);
        propertyToEdit.setDescription(description);
    
        
        int vendorId = Integer.parseInt(request.getParameter("vendor")); 
        if(propertyToEdit.getVendorsVendorid().getVendorid() != vendorId){ // compare the posted vendorid with the current vendor id of the property being edited
            
               Vendors theVendor = VendorDatabaseAccess.getVendorWithID(vendorId); // if they don't match get the new vendor from the database and attach to the property
               propertyToEdit.setVendorsVendorid(theVendor);
            
        }
        
        int propertyTypeId = Integer.parseInt(request.getParameter("propertytype"));
        if(propertyToEdit.getPropertytypestypeId().getTypeId() != propertyTypeId){
            
             Propertytypes propertyTypeForThisProperty = PropertyTypesDatabaseAccess.getPropertyTypeWithID(propertyTypeId);
             propertyToEdit.setPropertytypestypeId(propertyTypeForThisProperty);
            
            
        }
        // Get the GarageType Object
        int garageTypeId = Integer.parseInt(request.getParameter("garagetype"));
        if(propertyToEdit.getGaragetypesgarageId().getGarageId() != garageTypeId){
            
            Garagetypes garageTypeForThisProperty = GarageTypesDatabaseAccess.getGarageTypeWithID(garageTypeId);
            propertyToEdit.setGaragetypesgarageId(garageTypeForThisProperty);
        
        }
        
        // Get the Style Object
        int styleId = Integer.parseInt(request.getParameter("styletype"));
        if(propertyToEdit.getStylesstyleId().getStyleId() != styleId){
            
            Styles styleForThisProperty = StylesDatabaseAccess.getStyleWithID(styleId);
            propertyToEdit.setStylesstyleId(styleForThisProperty);

        }
        
        boolean propertyHasBeenUpdated = PropertiesDatabaseAccess.updateProperty(propertyToEdit);
        
        if(propertyHasBeenUpdated){
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
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
