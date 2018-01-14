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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import src.db.AgentDatabaseAccess;
import src.entities.Agents;

/**
 *
 * @author Stephen
 */
@MultipartConfig
@WebServlet(name = "UploadAgentImageServlet", urlPatterns = {"/UploadAgentImageServlet"})
public class UploadAgentImageServlet extends HttpServlet {

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
        
            Part filePart = request.getPart("agentimage"); // Retrieves <input type="file" name="agentimage">
            
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            
            InputStream fileContent = filePart.getInputStream();               
                  
            String pathForImage = "E:\\Netbeans\\LitRealty\\web\\agent\\agentImages";  // TODO -> How do I get this to work with relative URL??
            
            File uploads = new File(pathForImage);

            File file = new File(uploads, fileName);
            
            boolean imageUpdated = true;

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            }
            
            catch(Exception ex){
                imageUpdated = false;
                String nextpage = "error.jsp";
            }
            
            // if the image wasn't uploaded successfully forward to an error page
            if(!imageUpdated){
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                     
                dispatcher.forward(request, response);
            
            }
            
            else{
                
                CommitAgentsImage(request, response, fileName); // handoff to below method to process updating the entity in the database
            }
            
            
    }
    
    
    
    
    public void CommitAgentsImage(HttpServletRequest request, HttpServletResponse response, String fileName) throws ServletException{    
        
        Subject currentUser = SecurityUtils.getSubject();
       
        Session session = currentUser.getSession();

        Agents AgentToUpdate = (Agents)session.getAttribute("currentAgent");

        AgentToUpdate.setImage(fileName);

        boolean agentUpdated = AgentDatabaseAccess.updateAgentDetails(AgentToUpdate); // Commit changes to database if the new image has being successfully added

        // Was the Image updated in the db?
        if (agentUpdated){
            
            session.setAttribute("currentAgent", AgentToUpdate);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
             
            try {
                dispatcher.forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(UploadAgentImageServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
        
        // if not, forward to an error message
        else{
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
             
            try {
                dispatcher.forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(UploadAgentImageServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
