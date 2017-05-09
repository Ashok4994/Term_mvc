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
@WebServlet(name = "ChangePerm", urlPatterns = {"/ChangePerm"})
public class ChangePerm extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePerm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePerm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Integer dir_id = Integer.parseInt(request.getParameter("dirid"));
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("id");
        ArrayList<DirectoryBean> own_directories = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> subm_directories = new ArrayList<DirectoryBean>();
        ArrayList<DirectoryBean> supm_directories = new ArrayList<DirectoryBean>();
        ArrayList<Employee> emp_details = new ArrayList<Employee>();
        int level_id,team_id;
        boolean status = false;
        try {
             emp_details = RegisterationService.getdetails(uid);
            level_id=emp_details.get(0).getLevelId();
             team_id=emp_details.get(0).getTeamId();
            status = DirectoryService.changePerm(uid, dir_id);
            own_directories = DirectoryService.getown(uid);
            subm_directories = DirectoryService.getSubd(uid, level_id,team_id);
            supm_directories = DirectoryService.getSuperd(uid, level_id,team_id);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePerm.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (status) {
            request.setAttribute("own_dir", own_directories);
            request.setAttribute("sub_dir", subm_directories);
            request.setAttribute("supr_dir", supm_directories);
            request.setAttribute("success", "Directory restricted");
            request.getRequestDispatcher("view_dir.jsp").forward(request, response);
        } else {
            request.setAttribute("failure", "Directory not restricted");
            request.getRequestDispatcher("view_dir.jsp").forward(request, response);

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
