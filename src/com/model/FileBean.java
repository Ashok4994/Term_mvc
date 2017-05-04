/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Blob;

/**
 *
 * @author ashok
 */
public class FileBean {

    private Blob file;
    private String title;
    private int file_id;
    private int userid;
    private String type;

    public int getUId() {
        return userid;
    }

    public void setUId(int userid) {
        this.userid = userid;
    }
     public int getFiled() {
        return file_id;
    }

    public void setFileId(int file_id) {
        this.file_id = file_id;
    }

    public Blob getFiles() {
        return file;
    }

    public void setFiles(Blob file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
