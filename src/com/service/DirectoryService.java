/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DirectorDAO;
import java.sql.SQLException;

/**
 *
 * @author ashok
 */
public class DirectoryService {
   
    public static boolean createdir(int mid , String dirname, int dir_id, String permission) throws SQLException{
    
      boolean status=DirectorDAO.create(mid,dirname,dir_id,permission);    
        
        return status;
    }
            
    
    
    
}
