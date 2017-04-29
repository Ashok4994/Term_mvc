package com.service;

import java.sql.SQLException;

import com.dao.EmployeeDAO;
import com.utility.ResponseObject;

public class RegisterationService {

	public static boolean registeration(String firstname, String lastname, String address, String mobile, String email,
			String userid, String password, String cpassword) throws SQLException {

		boolean status;
		status = EmployeeDAO.registeration(firstname, lastname, address, mobile, email, userid, password, cpassword);
		return status;
	}

	public static ResponseObject authenticateLogin(Integer userid, String password) throws SQLException {
		ResponseObject fresponse = new ResponseObject();
		if (password.isEmpty()) {
			fresponse.setResponse("Invalid Password");
			fresponse.setStatus(false);
			return fresponse;
		} else {
			fresponse = EmployeeDAO.authenticateLogin(userid, password);
			return fresponse;
		}
	}

}
