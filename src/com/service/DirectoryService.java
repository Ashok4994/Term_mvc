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

    public static boolean createdir(int mid, String dirname, int dir_id, String permission) throws SQLException {

        boolean status = DirectorDAO.create(mid, dirname, dir_id, permission);

        return status;
    }

    public static ArrayList<DirectoryBean> getown(int user_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a = DirectorDAO.getOwnDirectories(user_id);
        return a;
    }

    public static ArrayList<DirectoryBean> getSubd(int user_id, int level_id, int team_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a = DirectorDAO.getSubDir(user_id, level_id, team_id);
        return a;
    }

    public static ArrayList<DirectoryBean> getmanagers(int m_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a = DirectorDAO.getMDirectories(m_id);
        return a;
    }

    public static ArrayList<DirectoryBean> getSuperd(int user_id, int level_id, int team_id) throws SQLException {
        ArrayList<DirectoryBean> a;
        a = DirectorDAO.getSuperDir(user_id, level_id, team_id);
        return a;

    }

    public static boolean changePerm(int uid, int dir_id) throws SQLException {
        boolean status;

        status = DirectorDAO.changePerm(uid, dir_id);
        return status;
    }

    public static boolean ateAssign(Integer uid, Integer dir_id, int mngr_id) throws SQLException {
        boolean st = DirectorDAO.ateAssign(uid, dir_id, mngr_id);
        return st;
    }

    public static ArrayList<DirectoryBean> getATEd(int user_id) throws SQLException {
         ArrayList<DirectoryBean> a;
        a = DirectorDAO.getATEDir(user_id);
        return a;
        
    }

}
