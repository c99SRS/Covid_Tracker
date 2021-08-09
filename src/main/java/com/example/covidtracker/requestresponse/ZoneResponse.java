package com.example.covidtracker.requestresponse;

public class ZoneResponse {


    private String numOfCases;
    private String zoneType;


    public String getNumOfCases() {
        return numOfCases;
    }

    public void setNumOfCases(String numOfCases) {
        this.numOfCases = numOfCases;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    @Override
    public String toString() {
        return "numOfCases='" + numOfCases + '\'' +
                ", zoneType='" + zoneType + '\'' ;
    }
}
