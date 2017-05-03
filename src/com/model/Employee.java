package com.model;

public class Employee {

    private int userid;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String role;
    private String status;
    private int manager_id;
    private int level_id;
    private int team_id;
    private String hierarchy;

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public int getManagerId() {
        return manager_id;
    }

    public void setManagerId(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setTeamId(int team_id) {
        this.team_id = team_id;
    }

    public int getTeamId() {
        return team_id;
    }

    public int getLevelId() {
        return level_id;
    }

    public void setLevelId(int level_id) {
        this.level_id = level_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

}
