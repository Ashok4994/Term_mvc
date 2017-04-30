/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author ashok
 */
public class DirectoryBean {

    private int manager_id;
    private String dir_name;
    private int dir_id;
    private String permission;

    public int getManagerId() {
        return manager_id;
    }

    public void setManagerId(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getDirId() {
        return dir_id;
    }

    public void setDirId(int dir_id) {
        this.dir_id = dir_id;
    }

    public String getDname() {
        return dir_name;
    }

    public void setDname(String dir_name) {
        this.dir_name = dir_name;
    }
     public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
