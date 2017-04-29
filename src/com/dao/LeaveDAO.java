package com.dao;

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LeaveDAO {

	public static boolean upload(Date s_Date, Date e_Date, String reason, int id, int mid) throws SQLException, ParseException {
	    
            
            String sql = "INSERT INTO leave2 values (?,?,?,?,?,?)";
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("in leave dao");
		PreparedStatement statement = DBAccess.getConnection().prepareStatement(sql);

		statement.setDate(1, s_Date);
		statement.setDate(2, e_Date);
		statement.setString(3, reason);
		statement.setInt(4, id);
		statement.setInt(5, mid);
		statement.setString(6, "pending");
		statement.executeUpdate();
		statement.close();
		return true;

	}

}
