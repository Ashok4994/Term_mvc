/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.LeaveService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ashok
 */
@WebServlet(name = "ApproveLeave", urlPatterns = {"/ApproveLeave"})
public class ApproveLeave extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String perm = request.getParameter("perm");
        Integer uid = Integer.parseInt(request.getParameter("empid"));
        boolean status=false;
        try {
            status=LeaveService.updateleave(perm,uid);
        } catch (SQLException ex) {
            Logger.getLogger(ApproveLeave.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(status) {
            response.sendRedirect(request.getContextPath() + "/user_home.jsp");
        }
        
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
