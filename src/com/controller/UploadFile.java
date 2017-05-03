/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DirectoryBean;
import com.model.Employee;
import com.service.DirectoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "UploadFile", urlPatterns = {"/UploadFile"})
public class UploadFile extends HttpServlet {

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

        ArrayList<DirectoryBean> own_dir_list = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> m_dir_list = new ArrayList<DirectoryBean>();
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        Integer mid = (Integer) session.getAttribute("manager_id");
        try {
            own_dir_list = DirectoryService.getown(uid);
            m_dir_list = DirectoryService.getmanagers(mid);
        } catch (SQLException ex) {
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("ownDirectoryList", own_dir_list);
        request.setAttribute("managers_dlist", m_dir_list);
        request.getRequestDispatcher("file_upload.jsp").forward(request, response);

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
