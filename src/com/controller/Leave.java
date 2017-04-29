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

import com.service.LeaveService;

/**
 * Servlet implementation class Leave
 */
@WebServlet("/Leave")
public class Leave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String start_date = request.getParameter("sdate").toString();
		String end_date = request.getParameter("enddate").toString();
		String reason = request.getParameter("reason");
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		Integer mid = (Integer) session.getAttribute("manager_id");
		//PrintWriter out = response.getWriter();
		//out.println("manager id=" + mid);
		boolean status;
		try {
			//out.print("before upload service");
			status = LeaveService.upload(start_date, end_date, reason, id, mid);
			//out.print("after upload service");
			if (status) {
				response.sendRedirect("user_home.jsp");
			} else {
				request.setAttribute("error", "Invalid fileds");
				RequestDispatcher rs = request.getRequestDispatcher("leave_request.jsp");
				rs.forward(request, response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}

}
