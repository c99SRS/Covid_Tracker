package com.example.covidtracker.requestresponse;

public class CovidResponse {

    private boolean updated;

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }


    @Override
    public String toString() {
        return "updated=" + updated ;
    }
}
