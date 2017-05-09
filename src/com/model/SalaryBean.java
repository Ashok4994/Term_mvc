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
public class SalaryBean {

    private int empid;
    private int annualsalary;
    private int bonus;
    private int msalary;

    public int getuserid() {
        return empid;
    }

    public void setuserid(int empid) {
        this.empid = empid;
    }

    public int getAnnualSalary() {
        return annualsalary;
    }

    public void setAnnualSalay(int annualsalary) {
        this.annualsalary = annualsalary;
    }

    public void setMonthlySalry(int msalary) {
        this.msalary = msalary;
    }

    public int getMonthlySalary() {
        return msalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
