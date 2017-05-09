/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.SalaryBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ashok
 */
public class AdminDAO {

    public static boolean updateUser(String role, String status, int mid, int salary, int uid,String m_hierarchy) throws SQLException {
        String sql = "update employee " + "set role= '" + role + "',"
                + "status= '" + status + "'," + "mid= "
                + mid +",hierarchy= '"+m_hierarchy+"'"+ " where userid= "+uid;
               
        Statement stmt = DBAccess.getConnection().createStatement();
        stmt.executeUpdate(sql);

        //String sql2 = "update salary " + "set annualsalary= " + salary + "where userid= " + uid;
        String sql3 = "insert into termproject.salary values(?,?,?,?)";

        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql3);
        pstm.setInt(1, salary);
        pstm.setInt(2, 0);
        pstm.setInt(3, 0);
        pstm.setInt(4, uid);
        int row = pstm.executeUpdate();
        if (row > 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<SalaryBean> getSalaryDetails() throws SQLException {

        ArrayList<SalaryBean> sal_list = new ArrayList<SalaryBean>();
        PreparedStatement stmt = DBAccess.getConnection()
                .prepareStatement("select * from salary");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            SalaryBean s = new SalaryBean();
            s.setAnnualSalay(rs.getInt("annualsalary"));
            s.setBonus(rs.getInt("bonus"));
            s.setMonthlySalry(rs.getInt("msalary"));
            s.setuserid(rs.getInt("empid"));
            sal_list.add(s);
        }

        return sal_list;

    }

    public static boolean updateSal(Integer annual_salary, Integer monthly_salary, Integer uid) throws SQLException {
        String sql2 = "update salary " + "set annualsalary= " + annual_salary +",bonus=0 where empid= " + uid;
        Statement stmt = DBAccess.getConnection().createStatement();
        stmt.executeUpdate(sql2);
        return true;
    }

}
