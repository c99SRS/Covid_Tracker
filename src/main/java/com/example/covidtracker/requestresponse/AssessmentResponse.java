package com.example.covidtracker.requestresponse;

public class AssessmentResponse {

    private String riskPercentage;


    public void setRiskPercentage(String riskPercentage) {
        this.riskPercentage = riskPercentage;
    }

    @Override
    public String toString() {
        return
                "riskPercentage='" + riskPercentage ;
    }
}
