package com.example.covidtracker.requestresponse;

public class AdminResponse {

    private Integer adminId;

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return
                "adminId=" + adminId;
    }
}
