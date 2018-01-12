/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.val;
import src.db.AgentDatabaseAccess;
import src.db.PropertiesDatabaseAccess;
import src.entities.Properties;

/**
 *
 * @author Stephen
 */
@WebServlet(name = "BuildAdminReportServlet", urlPatterns = {"/BuildAdminReportServlet"})
public class BuildAdminReportServlet extends HttpServlet {

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
        
            List agentList = AgentDatabaseAccess.getAllAgents();

           List<Properties> propertyList = PropertiesDatabaseAccess.getAllProperties();
           
           int totalNumberOfProperties = propertyList.size();
           
           List<Properties> OldestProperties = PropertiesDatabaseAccess.getTenOldestRecords();

           double totalPropertyPrice = 0;
           for(Properties aProperty:propertyList){

               totalPropertyPrice += aProperty.getPrice();
           }
           
           request.setAttribute("totalPropertyPrice", totalPropertyPrice);
           
           request.setAttribute("totalNumberOfProperties",totalNumberOfProperties);
           
           request.setAttribute("OldestProperties", OldestProperties);


         
            request.setAttribute("agentsForReport", agentList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminReport.jsp");

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
