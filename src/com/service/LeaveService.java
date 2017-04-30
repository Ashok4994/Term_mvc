package com.service;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.LeaveDAO;
import com.model.LeaveBean;
import java.util.ArrayList;
import java.util.List;

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

    public static List<LeaveBean> getStatus(int empid) throws SQLException {

        List<LeaveBean> leaveList = new ArrayList<LeaveBean>();
        leaveList = LeaveDAO.getStatus(empid);
         return leaveList;
    }

    public static List<LeaveBean> showlist(int empid) throws SQLException {

        List<LeaveBean> leaveList1 = new ArrayList<LeaveBean>();
        leaveList1 = LeaveDAO.showlist(empid);
         return leaveList1;
    }
    
    public static boolean updateleave(String perm,int uid) throws SQLException {
        boolean status=LeaveDAO.updateleave(perm,uid);
        return status;
    }
}
