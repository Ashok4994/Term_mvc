package com.dao;

import com.model.LeaveBean;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public static List<LeaveBean> getStatus(int empid) throws SQLException {

        List<LeaveBean> leaveList = new ArrayList<LeaveBean>();

        String sql = "SELECT * FROM termproject.leave2 where emp_id=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, empid);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            LeaveBean lb = new LeaveBean();
            lb.setstartDate(rs.getDate("startdate"));
            Date d = rs.getDate("startdate");
            lb.setendDate(rs.getDate("enddate"));
            lb.setreason(rs.getString("reason"));
            lb.setstatus(rs.getString("status"));
            leaveList.add(lb);
        }
        pstm.close();
        return leaveList;

    }

    public static List<LeaveBean> showlist(int empid) throws SQLException {

        List<LeaveBean> showList = new ArrayList<LeaveBean>();
        int empid1=0;
        String sql = "SELECT * FROM termproject.leave2 where man_id=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, empid);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            LeaveBean lb = new LeaveBean();
            lb.setstartDate(rs.getDate("startdate"));
            Date d = rs.getDate("startdate");
            lb.setendDate(rs.getDate("enddate"));
            lb.setreason(rs.getString("reason"));
            lb.setuserid(rs.getInt("emp_id"));
            empid1 = rs.getInt("emp_id");
            lb.setstatus(rs.getString("status"));
            showList.add(lb);
        }
        pstm.close();
        return showList;

    }
    
    public static boolean updateleave(String perm,int uid) throws SQLException {
        
    Statement stmt = DBAccess.getConnection().createStatement();    
    String sql = "update leave2 " + "set status= '" + perm + "'" + "where emp_id= " + uid;
        stmt.executeUpdate(sql);
        return true;
    }

}
