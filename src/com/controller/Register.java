package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.RegisterationService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fnm");
		String lname = request.getParameter("lnm");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("emailid");
		String uid = request.getParameter("userid");
		String passwd = request.getParameter("pswd");
		String cpassword = request.getParameter("cpass");
		boolean status;
		PrintWriter out = response.getWriter();
		out.print("Before try");
		try {
			status = RegisterationService.registeration(fname, lname, address, mobile, email, uid, passwd, cpassword);
			if (status) {
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("error", "Invalid fileds");
				RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
				rs.forward(request, response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			/*
			 * request.setAttribute("error", "All fields are mandatory.");
			 * RequestDispatcher rd =
			 * request.getRequestDispatcher("register.jsp"); rd.forward(request,
			 * response);
			 */
		}

	}

}
