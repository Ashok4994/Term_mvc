/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.FileBean;
import com.model.LeaveBean;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author ashok
 */
public class FileDAO {

    public static ArrayList<FileBean> getfiles(int dirid) throws SQLException {

        ArrayList<FileBean> flist = new ArrayList<FileBean>();

        String sql = "SELECT * FROM termproject.files where dir_id=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, dirid);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            FileBean fb = new FileBean();
            fb.setTitle(rs.getString("title"));
            fb.setFileId(rs.getInt("fil_id"));
            fb.setFiles(rs.getBlob("file"));
            fb.setUId(rs.getInt("userid"));
            fb.setType(rs.getString("type"));
            flist.add(fb);
        }
        pstm.close();
        return flist;

    }
    //getOnefile

    public static FileBean getOnefile(int fil_id) throws SQLException {

        FileBean fb = new FileBean();

        String sql = "SELECT * FROM termproject.files where fil_id=?";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, fil_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            fb.setTitle(rs.getString("title"));
            fb.setFileId(rs.getInt("fil_id"));
            fb.setFiles(rs.getBlob("file"));
            fb.setUId(rs.getInt("userid"));
            fb.setType(rs.getString("type"));

        }
        pstm.close();
        return fb;

    }

    public static boolean uploadFile(Integer dir_id, Part filePart, String title, Integer uid, int n) throws IOException, SQLException {
        boolean status = false;
        InputStream inputStream = null;
        String type_file = null;
        if (filePart != null) {
            type_file = filePart.getContentType();
            inputStream = filePart.getInputStream();
        }
        String sql = "INSERT INTO files values (?,?,?,?,?,?)";
        PreparedStatement pstm = DBAccess.getConnection().prepareStatement(sql);
        pstm.setInt(1, dir_id);
        pstm.setString(3, title);
        pstm.setString(4, type_file);
        pstm.setInt(5, uid);
        pstm.setInt(6, n);
        if (inputStream != null) {
            pstm.setBinaryStream(2, inputStream, (int) filePart.getSize());
        }
        int row = pstm.executeUpdate();
        return row > 0;

    }

}
