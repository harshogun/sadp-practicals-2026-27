package com.harsh.employee.model;

import java.math.BigDecimal;

public class Employee {

    private int eno;
    private String ename;
    private String designation;
    private String deptName;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(int eno, String ename, String designation,
                    String deptName, BigDecimal salary) {
        this.eno = eno;
        this.ename = ename;
        this.designation = designation;
        this.deptName = deptName;
        this.salary = salary;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}