package com.controller;

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
                                PrintWriter out = response.getWriter();

		try {
			resp = RegisterationService.authenticateLogin(user_id, pass);

			if (resp.getStatus()) {
				HttpSession session = request.getSession();
				session.setAttribute("id", user_id);
				int mid = resp.getManagerId();
				session.setAttribute("manager_id", mid);
				userRole = resp.getRole();

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
