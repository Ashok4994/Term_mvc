package com.dao;

import com.model.Employee;
import com.model.LeaveBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dao.DBAccess;
import com.utility.ResponseObject;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        pstm.setString(10, "inactive");
        pstm.setInt(11, 0);
        pstm.setInt(12, level_id);
        pstm.setInt(13, 0);
        pstm.setInt(14, 0);
        pstm.setString(15, null);
        pstm.executeUpdate();
        pstm.close();
        return true;
    }

    public static Boolean updateProfile(String firstname, String lastname, String address, String mobile, String email, int uid) throws SQLException {
        String sql = "update employee " + "set firstname= '" + firstname + "',"
                + "lastname= '" + lastname + "'," + "address= '"
                + address + "', " + "phone='"
                + mobile + "', " + "email='"
                + email + "'" + "where userid= "
                + uid;
        Statement stmt = DBAccess.getConnection().createStatement();
        stmt.executeUpdate(sql);

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

    public static ArrayList<Employee> getdetails(int empid) throws SQLException {
        ArrayList<Employee> emp_details = new ArrayList<Employee>();

        String sql = "SELECT * FROM termproject.employee where userid=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, empid);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Employee e = new Employee();
            e.setFirstname(rs.getString("firstname"));
            e.setLastname(rs.getString("lastname"));
            e.setAddress(rs.getString("address"));
            e.setEmail(rs.getString("email"));
            e.setPhone(rs.getString("phone"));
            e.setHierarchy(rs.getString("hierarchy"));
            e.setLevelId(rs.getInt("levelid"));
            e.setRole(rs.getString("role"));
            e.setStatus(rs.getString("status"));
            e.setManagerId(rs.getInt("mid"));
            e.setTeamId(rs.getInt("teamid"));
            emp_details.add(e);
        }
        return emp_details;
    }

    public static ArrayList<Employee> getEmployees(int empid) throws SQLException {
        ArrayList<Employee> man_emps = new ArrayList<Employee>();

        String sql = "SELECT * FROM termproject.employee where mid=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, empid);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Employee e = new Employee();
            e.setFirstname(rs.getString("firstname"));
            e.setLastname(rs.getString("lastname"));
            e.setAddress(rs.getString("address"));
            e.setEmail(rs.getString("email"));
            e.setPhone(rs.getString("phone"));
            e.setHierarchy(rs.getString("hierarchy"));
            e.setLevelId(rs.getInt("levelid"));
            e.setRole(rs.getString("role"));
            e.setUserId(rs.getInt("userid"));
            e.setStatus(rs.getString("status"));
            e.setManagerId(rs.getInt("mid"));
            e.setTeamId(rs.getInt("teamid"));
            man_emps.add(e);
        }
        return man_emps;
    }

    public static ArrayList<Employee> getuserlist() throws SQLException {
        ArrayList<Employee> emp_list = new ArrayList<Employee>();

        String sql = "SELECT * FROM termproject.employee;";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Employee e = new Employee();
            e.setFirstname(rs.getString("firstname"));
            e.setLastname(rs.getString("lastname"));
            e.setAddress(rs.getString("address"));
            e.setEmail(rs.getString("email"));
            e.setPhone(rs.getString("phone"));
            e.setHierarchy(rs.getString("hierarchy"));
            e.setUserId(rs.getInt("userid"));
            e.setLevelId(rs.getInt("levelid"));
            e.setRole(rs.getString("role"));
            e.setStatus(rs.getString("status"));
            e.setManagerId(rs.getInt("mid"));
            e.setTeamId(rs.getInt("teamid"));
            emp_list.add(e);
        }
        return emp_list;
    }

    public static ArrayList<Integer> getMngrlist() throws SQLException {
        ArrayList<Integer> mng_list = new ArrayList<Integer>();

        String sql = "SELECT userid FROM termproject.employee where role='manager';";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            mng_list.add(rs.getInt("userid"));
            
        }
        return mng_list;
        
    }

    public static boolean updateBonus(int bonus, int empid) throws SQLException {
        String sql2 = "update salary " + "set bonus= " + bonus + " where empid= " + empid;

        Statement stmt2 = DBAccess.getConnection().createStatement();
        stmt2.executeUpdate(sql2);

        return true;

    }
}
