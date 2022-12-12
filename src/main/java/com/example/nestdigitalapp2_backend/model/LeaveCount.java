package com.example.nestdigitalapp2_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leavecount")

public class LeaveCount {
    @Id
    @GeneratedValue
    private int id;
    private String empid;

    private String name;
    private int sickleave;
    private int casualleave;
    private int splleave;

    public LeaveCount() {
    }

    public LeaveCount(int id, String empid,String name,int sickleave, int casualleave, int splleave) {
        this.id = id;
        this.empid = empid;
        this.sickleave = sickleave;
        this.casualleave = casualleave;
        this.splleave = splleave;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpid(int id) {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public int getSickleave(int i) {
        return sickleave;
    }

    public void setSickleave(int sickleave) {
        this.sickleave = sickleave;
    }

    public int getCasualleave(int i) {
        return casualleave;
    }

    public void setCasualleave(int casualleave) {
        this.casualleave = casualleave;
    }

    public int getSplleave() {
        return splleave;
    }

    public void setSplleave(int splleave) {
        this.splleave = splleave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
