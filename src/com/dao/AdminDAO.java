/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ashok
 */
public class AdminDAO {
    
     public static boolean updateUser(String role,String status,int mid,int salary,int uid) throws SQLException {
            String sql = "update employee " + "set role= '" + role + "',"
                + "status= '" + status + "'," + "mid= "
                + mid + " where userid= "
                + uid;
      Statement stmt = DBAccess.getConnection().createStatement();
        stmt.executeUpdate(sql);  
        String sql2 = "update salary " + "set annualsalary= " + salary + "where userid= "+ uid;
           
      Statement stmt2 = DBAccess.getConnection().createStatement();
        stmt2.executeUpdate(sql2); 
        
         return true;
         
     }
    
}
