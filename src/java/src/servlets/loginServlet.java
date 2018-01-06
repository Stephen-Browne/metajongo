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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import src.db.AgentDatabaseAccess;
import src.entities.Agents;

/**
 *
 * @author Stephen
 */
public class loginServlet extends HttpServlet {

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
        
        try{
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        
        Subject currentUser =  SecurityUtils.getSubject(); // Almost everything you do in shiro is based on the current executing user -> the subject. This can be retrieved anywhere in your code
        
        
        try{
        currentUser.login(token);
        }catch(Exception ex){
            String nextPage = "login.jsp";
             RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
               dispatcher.forward(request, response);
        }
        
        
        Agents currentAgent = AgentDatabaseAccess.getAgentByUsername(username); // Get all details for this agent 
        
        HttpSession session = request.getSession();
        
        session.setAttribute("currentAgent", currentAgent); // Add details to the session
        
        String nextPage = "/agent/agentHome.jsp";
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        
        
        
        
        dispatcher.forward(request, response);
        
        
        }catch (Exception ex){
            System.out.println(ex.toString());
            
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
