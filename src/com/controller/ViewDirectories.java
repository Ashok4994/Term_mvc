/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DirectoryBean;
import com.model.Employee;
import com.service.DirectoryService;
import com.service.RegisterationService;
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
@WebServlet(name = "ViewDirectories", urlPatterns = {"/ViewDirectories"})
public class ViewDirectories extends HttpServlet {

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

        HttpSession session = request.getSession();
        int user_id = (Integer) session.getAttribute("id");
        ArrayList<DirectoryBean> own_directories = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> subm_directories = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> supm_directories = new ArrayList<DirectoryBean>();
        ArrayList<Employee> emp_details = new ArrayList<Employee>();
        int i=0,level_id;
        try {
            emp_details = RegisterationService.getdetails(user_id);
            level_id=emp_details.get(0).getLevelId();
            own_directories = DirectoryService.getown(user_id);
            subm_directories = DirectoryService.getSubd(user_id,level_id);
            supm_directories = DirectoryService.getSuperd(user_id,level_id);
        } catch (SQLException ex) {
            Logger.getLogger(ViewDirectories.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("own_dir",own_directories );
        request.setAttribute("sub_dir",subm_directories );
        request.setAttribute("supr_dir",supm_directories );
        request.getRequestDispatcher("view_dir.jsp").forward(request, response);
        

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
