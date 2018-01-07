/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Types;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import src.db.GarageTypesDatabaseAccess;
import src.db.PropertiesDatabaseAccess;
import src.db.PropertyTypesDatabaseAccess;
import src.db.StylesDatabaseAccess;
import src.db.VendorDatabaseAccess;
import src.entities.Agents;
import src.entities.Garagetypes;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.Styles;
import src.entities.Vendors;

/**
 *
 * @author Stephen
 */
@MultipartConfig
@WebServlet(name = "AddPropertyServlet", urlPatterns = {"/AddPropertyServlet"})
public class AddPropertyServlet extends HttpServlet {

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
        
        // NEED TO REFACTOR, SEPARATE FORM FOR IMAGE UPLOAD BECAUSE JAVA IS AWKWARD AF
       
        //Get Values from form...
        // first we'll get the values which don't require going to the db
        
      
        String cityCounty = request.getParameter("county");
        
        if(cityCounty == null){  // If this is null we've come from the insert image form to pass off to the handleImageForm method
            handleImageForm(request, response);
        }
        
        
        String street = request.getParameter("street");
        int numberOfBedrooms = Integer.parseInt(request.getParameter("numberofbedrooms"));
        double numberOfBathrooms = Double.parseDouble(request.getParameter("numberofbathrooms"));
        int squareFeet = Integer.parseInt(request.getParameter("squarefeet"));
        String lotSize = request.getParameter("lotsize");
        String berRating = request.getParameter("ber");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        Short garageSize = Short.parseShort(request.getParameter("garagesize"));
        Date currentDate = new Date();
        int listNumber = ThreadLocalRandom.current().nextInt(10000,1000000); // Generate random listing number
       
        HttpSession session = request.getSession();
        Agents thisAgent = (Agents)session.getAttribute("currentAgent");
        
        
        
        // The next attributes will require going to the database to get the corressponding objects for the inserted IDs
        
        // First get the vendor, which was selected..
        int vendorId = Integer.parseInt(request.getParameter("vendor"));
        Vendors theVendor = VendorDatabaseAccess.getVendorWithID(vendorId);
        
        // Get the selected PropertyType Object
        int propertyTypeId = Integer.parseInt(request.getParameter("propertytype"));
        Propertytypes propertyTypeForThisProperty = PropertyTypesDatabaseAccess.getPropertyTypeWithID(propertyTypeId);
        
        // Get the GarageType Object
        int garageTypeId = Integer.parseInt(request.getParameter("garagetype"));
        Garagetypes garageTypeForThisProperty = GarageTypesDatabaseAccess.getGarageTypeWithID(garageTypeId);
        
        // Get the Style Object
        int styleId = Integer.parseInt(request.getParameter("styletype"));
        Styles styleForThisProperty = StylesDatabaseAccess.getStyleWithID(styleId);
        
        
        // Try and insert the following property object, if it's successful save the image to the folder
        
        Properties propertyToInsert = new Properties();
       
        propertyToInsert.setAgentsagentId(thisAgent);
        propertyToInsert.setVendorsVendorid(theVendor);
        propertyToInsert.setStreet(street);
        propertyToInsert.setBathrooms(numberOfBathrooms);
        propertyToInsert.setBedrooms(numberOfBedrooms);
        propertyToInsert.setBerRating(berRating);
        propertyToInsert.setCity(cityCounty);
        propertyToInsert.setDateAdded(currentDate);
        propertyToInsert.setGaragetypesgarageId(garageTypeForThisProperty);
        propertyToInsert.setPropertytypestypeId(propertyTypeForThisProperty);
        propertyToInsert.setStylesstyleId(styleForThisProperty);
        propertyToInsert.setGaragesize(garageSize);
        propertyToInsert.setDescription(description);
        propertyToInsert.setLotsize(lotSize);
        propertyToInsert.setPrice(price);
        propertyToInsert.setListingNum(listNumber);
        
        
        session.setAttribute("propertyToInsert", propertyToInsert); // Add the property to session we'll access once the image has being uploaded
        
    
        // Send to Form to get Image for property
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddImageForInsertProperty.jsp");
        
        dispatcher.forward(request, response);
        
               
    }
    
    public void handleImageForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String fileName = null;
        
        // Get Name of Property Photo
        Part filePart = request.getPart("propertyimage");
            
        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
       
        
        HttpSession session = request.getSession();
        
        Properties propertyToInsert = (Properties)session.getAttribute("propertyToInsert");
        
        if(fileName != null){
            
            propertyToInsert.setPhoto(fileName);
        
        }
        
        
        boolean wasInserted = PropertiesDatabaseAccess.insertProperty(propertyToInsert);
        
        
        if(wasInserted){
            
            InputStream fileContent = filePart.getInputStream();               

            String pathForImage = "E:\\Netbeans\\LitRealty\\web\\imageResources";  // TODO -> How do I get this to work with relative URL??

            File uploads = new File(pathForImage);

            File file = new File(uploads, fileName);
            
             try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }catch(Exception ex){
                 RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                 dispatcher.forward(request, response);
            }
             
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
