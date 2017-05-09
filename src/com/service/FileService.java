package com.service;

import com.dao.DirectorDAO;
import com.dao.FileDAO;
import com.model.DirectoryBean;
import com.model.FileBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Part;

public class FileService {
    
    //getfile
    
     public static ArrayList<FileBean> getfile(int dir_id) throws SQLException {
        ArrayList<FileBean> flist;
        flist = FileDAO.getfiles(dir_id);
        return flist;
    }
     public static FileBean getOnefile(int fil_id) throws SQLException {
        FileBean file;
        file = FileDAO.getOnefile(fil_id);
        return file;
    }

    public static boolean uploadFile(Integer dir_id, Part filePart, String title, Integer uid, int n) throws IOException, SQLException {
     boolean status;
     status=FileDAO.uploadFile(dir_id,filePart,title,uid,n);
     return status;
    }

    
    
}
