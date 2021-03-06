/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Employee;
import com.service.AdminService;
import com.service.RegisterationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashok
 */
@WebServlet(name = "AdminUpdate", urlPatterns = {"/AdminUpdate"})
public class AdminUpdate extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        String role = request.getParameter("role");
        String status = request.getParameter("stat");
        Integer mid = Integer.parseInt(request.getParameter("mid"));
        HashMap<Integer,String> mngr_hierarchy=new HashMap<Integer,String>();
        
        Integer salary = Integer.parseInt(request.getParameter("sal"));
        Integer uid = Integer.parseInt(request.getParameter("empid"));
        ArrayList<Employee> active_emp_list = new ArrayList<Employee>();
        ArrayList<Employee> inactive_emp_list = new ArrayList<Employee>();
        ArrayList<Integer> mngr_list = new ArrayList<Integer>();

        boolean stat;

        try {
            mngr_hierarchy=RegisterationService.getManHierarchy(mid);
            stat = AdminService.updateuser(role, status, mid, salary, uid,mngr_hierarchy);
            active_emp_list = RegisterationService.getActiveuserlist();
            inactive_emp_list = RegisterationService.getInActiveuserlist();
            mngr_list = RegisterationService.getMngrlist();
        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (stat = true) {
            request.setAttribute("active_emplist", active_emp_list);
            request.setAttribute("inactive_emplist", inactive_emp_list);
            request.setAttribute("manager_list", mngr_list);
            RequestDispatcher rd = request.getRequestDispatcher("admin_user_update.jsp");
            rd.forward(request, response);
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
