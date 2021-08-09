package com.example.covidtracker.requestresponse;

public class UserResponse {

    private Integer userId;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "userId=" + userId;
    }
}
