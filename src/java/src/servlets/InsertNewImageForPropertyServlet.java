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
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import src.db.ImagesDatabaseAccess;
import src.entities.Images;
import src.entities.Properties;

/**
 *
 * @author Stephen
 */
@MultipartConfig
@WebServlet(name = "InsertNewImageForPropertyServlet", urlPatterns = {"/InsertNewImageForPropertyServlet"})
public class InsertNewImageForPropertyServlet extends HttpServlet {

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
     
        String fileName = null;
        
        // Get Name of Property Photo
        Part filePart = request.getPart("imagetoadd");
            
        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
       
        Subject CurrentUser = SecurityUtils.getSubject();
        
        Session session = CurrentUser.getSession();
        
        Properties propertyToAddImageFor = (Properties)session.getAttribute("propertyForImageUpdate");
        
        boolean wasInserted = false;
        
        Images newImage = new Images();
        
        if(fileName != null){
            
            newImage = new Images();
            
            newImage.setImageName(fileName);
            
            newImage.setPropertiesId(propertyToAddImageFor);
            
            wasInserted = ImagesDatabaseAccess.InsertImage(newImage);
        
        }
        
        if(wasInserted){
              
            propertyToAddImageFor.getImagesCollection().add(newImage);  
            
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
