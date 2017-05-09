/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.AdminDAO;
import com.model.SalaryBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ashok
 */
public class AdminService {

    public static boolean updateuser(String role, String status, int mid, int salary, int uid,HashMap<Integer,String> mngr_hierarchy) throws SQLException {
             
        String m_hierarchy=mngr_hierarchy.get(mid);
        String hier=m_hierarchy+"/"+uid;
        boolean stat = AdminDAO.updateUser(role, status, mid, salary, uid,hier);
        return stat;

    }

    public static ArrayList<SalaryBean> getSalList() throws SQLException {

        ArrayList<SalaryBean> sal = new ArrayList<SalaryBean>();
        sal = AdminDAO.getSalaryDetails();
        return sal;
    }

    public static boolean updateSalary(Integer annual_salary, Integer monthly_salary, Integer uid) throws SQLException {
    
    boolean status;
    int al_salary=annual_salary-monthly_salary;
    status=AdminDAO.updateSal(al_salary,monthly_salary,uid);
    return status;
    }
}
