package com.service;

import java.sql.SQLException;

import com.dao.EmployeeDAO;
import com.dao.LeaveDAO;
import com.model.Employee;
import com.model.LeaveBean;
import com.utility.ResponseObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterationService {

    public static boolean registeration(String firstname, String lastname, String address, String mobile, String email,
            String userid, String password, String cpassword) throws SQLException {

        boolean status;
        status = EmployeeDAO.registeration(firstname, lastname, address, mobile, email, userid, password, cpassword);
        return status;
    }

    public static boolean updateProfile(String firstname, String lastname, String address, String mobile, String email, int uid) throws SQLException {

        boolean status;
        status = EmployeeDAO.updateProfile(firstname, lastname, address, mobile, email, uid);
        return status;
    }

    public static ResponseObject authenticateLogin(Integer userid, String password) throws SQLException {
        ResponseObject fresponse = new ResponseObject();
        if (password.isEmpty()) {
            fresponse.setResponse("Password is empty");
            fresponse.setStatus(false);
            return fresponse;
            
        } else {
            fresponse = EmployeeDAO.authenticateLogin(userid, password);
            return fresponse;
        }
    }

    public static ArrayList<Employee> getdetails(int empid) throws SQLException {

        ArrayList<Employee> employee_details = new ArrayList<Employee>();
        employee_details = EmployeeDAO.getdetails(empid);
        return employee_details;
    }

    public static ArrayList<Employee> getEmployees(int empid) throws SQLException {

        ArrayList<Employee> mngr_emps = new ArrayList<Employee>();
        mngr_emps = EmployeeDAO.getEmployees(empid);
        return mngr_emps;
    }
 
  
    
      public static ArrayList<Employee> getActiveuserlist() throws SQLException {

        ArrayList<Employee> employee_list = new ArrayList<Employee>();
        employee_list = EmployeeDAO.getActiveuserlist();
        return employee_list;
    }
     public static ArrayList<Employee> getInActiveuserlist() throws SQLException {

        ArrayList<Employee> employee_list = new ArrayList<Employee>();
        employee_list = EmployeeDAO.getInActiveuserlist();
        return employee_list;
    }
    

    public static ArrayList<Integer> getMngrlist() throws SQLException {

        ArrayList<Integer> m_list = new ArrayList<Integer>();
        m_list = EmployeeDAO.getMngrlist();
        return m_list;
    }

    public static boolean updateBonus(int bonus, int empid) throws SQLException {
        boolean status = EmployeeDAO.updateBonus(bonus, empid);
        return status;
    }

    public static HashMap<Integer, String> getManHierarchy(Integer mid) throws SQLException {
       HashMap<Integer, String> mngr=new HashMap<Integer, String>();
       mngr=EmployeeDAO.getMngrHierarchy(mid);
       
       return mngr;
        
        
    }

    public static ArrayList<Employee> getOtherTeamEmployees(int team_id) throws SQLException {
        
         ArrayList<Employee> o_list = new ArrayList<Employee>();
        o_list = EmployeeDAO.getOTeamEmpList(team_id);
        return o_list;
    }
}
