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

    //getSubDir
    public static ArrayList<DirectoryBean> getSubDir(int user_id, int level_id, int team_id) throws SQLException {
        ArrayList<DirectoryBean> sub_dir = new ArrayList<DirectoryBean>();
        String sql = "SELECT d.dir_id,d.directory_name,d.permission,d.manager_id,e.hierarchy FROM termproject.directory d,termproject.employee e where e.userid=d.manager_id and e.levelid<? and teamid=? order by manager_id desc";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, level_id);
        pstm.setInt(2, team_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            db.setManagerId(rs.getInt("manager_id"));
            db.setHierarchy(rs.getString("hierarchy"));
            sub_dir.add(db);
        }
        return sub_dir;
    }

    public static ArrayList<DirectoryBean> getMDirectories(int m_id) throws SQLException {
        ArrayList<DirectoryBean> m_dir = new ArrayList<DirectoryBean>();
        String sql = "SELECT * FROM termproject.directory where manager_id=? and (permission='public' or permission='protected' or permission='default');";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, m_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            m_dir.add(db);
        }
        return m_dir;
    }

    public static ArrayList<DirectoryBean> getSuperDir(int user_id, int level_id, int team_id) throws SQLException {
        ArrayList<DirectoryBean> m_dir = new ArrayList<DirectoryBean>();
        //String sql = "SELECT d.dir_id,d.directory_name,d.permission FROM termproject.directory d,termproject.employee e where e.userid=d.manager_id and (permission='public' or permission='protected' or permission='default') and e.levelid>? and \n" +
        // "d.dir_id not in(select dir_id from termproject.directory2);";
        String sql = "SELECT d.dir_id,d.directory_name,d.permission FROM termproject.directory d,termproject.employee e where e.userid=d.manager_id and e.teamid=" + team_id + " and (permission='public' or permission='protected' or permission='default') and e.levelid>? and\n"
                + "d.dir_id not in(select dir_id from termproject.directory2 where level_id>?);";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, level_id);
        pstm.setInt(2, level_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            m_dir.add(db);
        }
        return m_dir;

    }

    public static boolean changePerm(int uid, int dir_id) throws SQLException {
        String sql = "INSERT INTO directory2 values (?,?,?,?)";
        int level = uid % 10;
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, dir_id);
        pstm.setString(2, "private");
        pstm.setInt(3, uid);
        pstm.setInt(4, level);
        int row = pstm.executeUpdate();
        pstm.close();
        return row > 0 ? true : false;
    }

    public static boolean ateAssign(Integer uid, Integer dir_id, int mngr_id) throws SQLException {
        String sql = "INSERT INTO directory3 values (?,?,?)";

        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, uid);
        pstm.setInt(2, dir_id);
        pstm.setInt(3, mngr_id);

        int row = pstm.executeUpdate();
        pstm.close();
        return row > 0 ? true : false;

    }

    public static ArrayList<DirectoryBean> getATEDir(int user_id) throws SQLException {
        ArrayList<DirectoryBean> m_dir = new ArrayList<DirectoryBean>();
        String sql = "select * from termproject.directory g where g.dir_id in (select d.dirid FROM termproject.directory3 d,termproject.employee e where d.empid=e.userid and e.userid=?)";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, user_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            DirectoryBean db = new DirectoryBean();
            db.setDname(rs.getString("directory_name"));
            db.setDirId(rs.getInt("dir_id"));
            db.setPermission(rs.getString("permission"));
            m_dir.add(db);
        }
        pstm.close();
        return m_dir;
    }
}
