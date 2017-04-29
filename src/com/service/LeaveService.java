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
            
             java.util.Date startDate = null;
		java.util.Date endDate = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		startDate = sdf.parse(start_date);
		endDate = sdf.parse(end_date);
              java.sql.Date sDate = new java.sql.Date(startDate.getTime());
		java.sql.Date eDate = new java.sql.Date(endDate.getTime());
            

		boolean status;

		
		status = LeaveDAO.upload(sDate, eDate, reason, id, mid);

		return status;

	}

}
