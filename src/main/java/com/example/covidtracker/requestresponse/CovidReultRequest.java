package com.example.covidtracker.requestresponse;

public class CovidReultRequest {


    // Sample request - {"userId":"1","adminId":"2","result":"positive"}

    private Integer userId;
    private Integer adminId;
    private String result;


    public Integer getUserId() {
        return userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getResult() {
        return result;
    }
}
