package com.example.covidtracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String pinCode;
    @Column
    private int noOfCases;
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getNoOfCases() {
        return noOfCases;
    }

    public void setNoOfCases(int noOfCases) {
        this.noOfCases = noOfCases;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}

