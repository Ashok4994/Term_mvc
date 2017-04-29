package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.ResponseObject;

public class EmployeeDAO {

	public static Boolean registeration(String firstname, String lastname, String address, String mobile, String email,
			String userid, String password, String cpassword) throws SQLException {

		Integer a = Integer.parseInt(userid);
		Integer level_id = a % 10;
		String insert = "insert into employee values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = DBAccess.getConnection().prepareStatement(insert);
		pstm.setString(1, firstname);
		pstm.setString(2, lastname);
		pstm.setString(3, address);
		pstm.setString(4, mobile);
		pstm.setString(5, email);
		pstm.setInt(6, a);
		pstm.setString(7, password);
		pstm.setString(8, cpassword);
		pstm.setString(9, "employee");
		pstm.setString(10, null);
		pstm.setString(11, null);
		pstm.setInt(12, level_id);
		pstm.setInt(13, 0);
		pstm.setInt(14, 0);
		pstm.setString(15, null);
		pstm.executeUpdate();
		pstm.close();
		return true;
	}

	public static ResponseObject authenticateLogin(Integer userid, String password) throws SQLException {
		ResponseObject resp = new ResponseObject();
		PreparedStatement stmt = DBAccess.getConnection()
				.prepareStatement("select * from employee where userid = ? and password = ? ");
		stmt.setInt(1, userid);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			resp.setStatus(true);
			resp.setResponse(rs.getString(2));
			resp.setRole(rs.getString("role"));
			resp.setManagerId(rs.getInt("mid"));
			stmt.close();
			return resp;
		}
		resp.setStatus(false);
		// fresResponse.setId(0);
		resp.setResponse("Invalid Login Credentials");
		stmt.close();
		return resp;
	}

}
