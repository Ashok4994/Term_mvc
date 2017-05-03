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
import com.service.RegisterationService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ashok
 */
@WebServlet(name = "ApproveBonus", urlPatterns = {"/ApproveBonus"})
public class ApproveBonus extends HttpServlet {

   

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
       
        Integer bonus =Integer.parseInt(request.getParameter("bonus"));
        Integer uid=Integer.parseInt(request.getParameter("empid"));
        boolean updt=false;
        try {
            updt=RegisterationService.updateBonus(bonus,uid);
        } catch (SQLException ex) {
            Logger.getLogger(ApproveBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(updt) {
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
