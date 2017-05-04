package com.service;

import com.dao.DirectorDAO;
import com.dao.FileDAO;
import com.model.DirectoryBean;
import com.model.FileBean;
import java.sql.SQLException;
import java.util.ArrayList;

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

    
    
}
