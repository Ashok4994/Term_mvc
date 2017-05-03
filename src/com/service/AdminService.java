/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.AdminDAO;
import java.sql.SQLException;

/**
 *
 * @author ashok
 */
public class AdminService {
    
    
     public static boolean updateuser(String role,String status,int mid,int salary,int uid) throws SQLException{
         
         boolean stat=AdminDAO.updateUser(role,status,mid,salary,uid);
         return stat;
         
     }
    
}
