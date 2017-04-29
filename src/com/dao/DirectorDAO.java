/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.*;

/**
 *
 * @author ashok
 */
public class DirectorDAO {

    public static boolean create(int mid, String dirname, int dir_id, String permission) throws SQLException {

        String sql = "INSERT INTO directory values (?,?,?,?)";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, mid);
        pstm.setString(2, dirname);
        pstm.setInt(3, dir_id);
        pstm.setString(4, permission);
        pstm.executeUpdate();
        pstm.close();
        return true;

    }

}
