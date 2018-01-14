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
import src.db.AgentDatabaseAccess;
import src.entities.Agents;

/**
 *
 * @author Stephen
 */
public class UpdateAgentDetailsServlet extends HttpServlet {

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

        // Get details posted from form
        String newName = request.getParameter("name"); 
        String newPhoneNumber = request.getParameter("phonenumber"); 
        String newFax = request.getParameter("fax"); 
        String newEmail = request.getParameter("email"); 
        
        Agents AgentToUpdate = (Agents)session.getAttribute("currentAgent");
        
        AgentToUpdate.setName(newName);
        AgentToUpdate.setPhone(newPhoneNumber);
        AgentToUpdate.setFax(newFax);
        AgentToUpdate.setEmail(newEmail);
        
        boolean agentUpdated = AgentDatabaseAccess.updateAgentDetails(AgentToUpdate);
        
        String nextPage = "error.jsp";
        
        if(agentUpdated){
            
            nextPage = "success.jsp";
            
            // Update session details
            
            session.setAttribute("currentAgent", AgentToUpdate);
            
            
            
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
