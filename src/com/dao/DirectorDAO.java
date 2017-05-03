/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.DirectoryBean;
import com.model.LeaveBean;
import java.sql.*;
import java.util.ArrayList;

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

    public static ArrayList<DirectoryBean> getOwnDirectories(int user_id) throws SQLException {
        ArrayList<DirectoryBean> own_dir = new ArrayList<DirectoryBean>();
        String sql = "SELECT * FROM termproject.directory where manager_id=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, user_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDirId(rs.getInt("dir_id"));
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            own_dir.add(db);
        }
        return own_dir;
    }

    public static ArrayList<DirectoryBean> getMDirectories(int m_id) throws SQLException {
        ArrayList<DirectoryBean> m_dir = new ArrayList<DirectoryBean>();
        String sql = "SELECT * FROM termproject.directory where manager_id=? and (permission='public' or permission='private' or permission='default');";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, m_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDirId(rs.getInt("dir_id"));
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            m_dir.add(db);
        }
        return m_dir;
    }
}
