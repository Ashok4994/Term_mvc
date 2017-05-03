package com.controller;

import com.model.DirectoryBean;
import com.model.Employee;
import com.model.LeaveBean;
import com.service.DirectoryService;
import com.service.LeaveService;
import com.service.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.RegisterationService;
import com.utility.ResponseObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uid = request.getParameter("uid").trim();
        String pass = request.getParameter("passwd").trim();
        String userRole = null;
        Integer user_id = Integer.parseInt(uid);
        ResponseObject resp = new ResponseObject();

        //List<LeaveBean> leaveList = new ArrayList<LeaveBean>();
        //List<LeaveBean> approve_leaveList = new ArrayList<LeaveBean>();
        //ArrayList<DirectoryBean> own_dir_list = new ArrayList<DirectoryBean>();
        //ArrayList<DirectoryBean> m_dir_list = new ArrayList<DirectoryBean>();
        ArrayList<Employee> emp_details = new ArrayList<Employee>();
        ArrayList<Employee> a_emp_list = new ArrayList<Employee>();
        //ArrayList<Employee> manager_emp_list = new ArrayList<Employee>();
        ArrayList<Integer> mngr_list = new ArrayList<Integer>();
        try {
            resp = RegisterationService.authenticateLogin(user_id, pass);

            if (resp.getStatus()) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user_id);
                int mid = resp.getManagerId();
                session.setAttribute("manager_id", mid);
                userRole = resp.getRole();

                if (userRole.equals("employee") || userRole.equals("manager")) {

                   // leaveList = LeaveService.getStatus(user_id);
                   // approve_leaveList = LeaveService.showlist(user_id);
                    //own_dir_list = DirectoryService.getown(user_id);
                    //m_dir_list = DirectoryService.getmanagers(resp.getManagerId());
                    emp_details = RegisterationService.getdetails(user_id);
                     //manager_emp_list = RegisterationService.getEmployees(user_id);
                    //session.setAttribute("leaveList", leaveList);
                    //session.setAttribute("approvalList", approve_leaveList);
                    //session.setAttribute("ownDirectoryList", own_dir_list);
                    //session.setAttribute("managers_dlist", m_dir_list);
                    session.setAttribute("emp_details", emp_details);
                    //session.setAttribute("mngr_emps", manager_emp_list);
                    response.sendRedirect(request.getContextPath() + "/user_home.jsp");

                } else {
                    a_emp_list = RegisterationService.getuserlist();
                    mngr_list = RegisterationService.getMngrlist();
                    session.setAttribute("emp_list", a_emp_list);
                    session.setAttribute("mng_list", mngr_list);
                    response.sendRedirect(request.getContextPath() + "/admin_home.jsp");
                }
                /*
				switch (userRole) { // check user role and redirect
				case "employee":
					response.sendRedirect(request.getContextPath() + "/user_home.jsp");

					break;
				case "admin":
					response.sendRedirect(request.getContextPath() + "/admin_home.jsp");
					break;
				case "manager":
					response.sendRedirect(request.getContextPath() + "/user_home.jsp");
					break;
				default:
					request.setAttribute("errormsg", "Invalid Credentials");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				}
                 */
            } else {
                request.setAttribute("loginerror", resp.getResponse());
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
