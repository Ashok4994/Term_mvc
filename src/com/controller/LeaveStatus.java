/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.LeaveBean;
import com.service.LeaveService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashok
 */
@WebServlet(name = "LeaveStatus", urlPatterns = {"/LeaveStatus"})
public class LeaveStatus extends HttpServlet {

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
        List<LeaveBean> leaveList = new ArrayList<LeaveBean>();
      HttpSession session=request.getSession();  
      Integer user_id=(Integer)session.getAttribute("id");
        try {  
            leaveList = LeaveService.getStatus(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(LeaveStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("leaveList",leaveList);
        request.getRequestDispatcher("leave_status.jsp").forward(request, response);
        
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
