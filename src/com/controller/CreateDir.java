/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.service.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashok
 */
public class CreateDir extends HttpServlet {

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
        String dir_name = request.getParameter("name");
        String dir_id = request.getParameter("id");
        String perm = request.getParameter("perm");
        Integer dirid = Integer.parseInt(dir_id);

        HttpSession session = request.getSession();
        
        Integer id = (Integer) session.getAttribute("id");
        boolean status;
        try {

            status = DirectoryService.createdir(id, dir_name, dirid, perm);

            if (status) {
                response.sendRedirect("user_home.jsp");
            } else {
                request.setAttribute("error", "Invalid fileds");
                RequestDispatcher rs = request.getRequestDispatcher("create_dir.jsp");
                rs.forward(request, response);
            }
        } catch (Exception e1) {
            e1.printStackTrace();

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
