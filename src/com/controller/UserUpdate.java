/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.service.RegisterationService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "UserUpdate", urlPatterns = {"/UserUpdate"})
public class UserUpdate extends HttpServlet {

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
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile_number");
        String email = request.getParameter("email_id");
        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("id");
        boolean status;
        try {
            status = RegisterationService.updateProfile(fname, lname, address, mobile, email, userid);
            if (status) {
                response.sendRedirect("user_home.jsp");
            } else {
                request.setAttribute("error", "Invalid fileds");
                RequestDispatcher rs = request.getRequestDispatcher("update_profile.jsp");
                rs.forward(request, response);
            }
        } catch (Exception e1) {
            e1.printStackTrace();

        }

    }
}
    
