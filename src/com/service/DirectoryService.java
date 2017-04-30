/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DirectorDAO;
import com.model.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ashok
 */
public class DirectoryService {
   
    public static boolean createdir(int mid , String dirname, int dir_id, String permission) throws SQLException{
    
      boolean status=DirectorDAO.create(mid,dirname,dir_id,permission);    
        
        return status;
    }
            
    public static ArrayList<DirectoryBean> getown(int user_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a=DirectorDAO.getOwnDirectories(user_id);
        return a;
    }
    public static ArrayList<DirectoryBean> getmanagers(int m_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a=DirectorDAO.getMDirectories(m_id);
        return a;
    }
    
    
}
