package com.example.covidtracker.model;

public enum UserType {

    ADMIN(1),
    USER(0);

    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    UserType(int type){
        this.type = type;
    }

}
