package com.service;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.LeaveDAO;

public class LeaveService {

	public static boolean upload(String start_date, String end_date, String reason, Integer id, Integer mid)
			throws SQLException, ParseException {

		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("in leave service");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		startDate = sdf.parse(start_date);
		endDate = sdf.parse(end_date);
		boolean status;

		java.sql.Date s_Date = new java.sql.Date(startDate.getTime());
		java.sql.Date e_Date = new java.sql.Date(endDate.getTime());

		status = LeaveDAO.upload(s_Date, e_Date, reason, id, mid);

		return status;

	}

}
