package com.example.covidtracker.service;

import com.example.covidtracker.model.SelfAssessment;
import com.example.covidtracker.model.User;
import com.example.covidtracker.model.UserType;
import com.example.covidtracker.repositories.SelfAssessmentRepository;
import com.example.covidtracker.repositories.UserRepository;
import com.example.covidtracker.requestresponse.AssessmentRequest;
import com.example.covidtracker.requestresponse.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SelfAssessmentRepository assessmentRepository;


    public Integer createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPhoneNumber(userRequest.getPhoneNo());
        user.setPinCode(userRequest.getPinCode());
        user.setUserType(UserType.USER.getType());

        User newUser = userRepository.save(user);

        return newUser.getId();
    }


    public String createUserAssessment(AssessmentRequest assessmentRequest) {
        SelfAssessment selfAssessment = new SelfAssessment();
        selfAssessment.setUserId(assessmentRequest.getUserId());
        selfAssessment.setSymptoms(assessmentRequest.getSymptoms());
        selfAssessment.setTravelHistory(assessmentRequest.isTravelHistory());
        selfAssessment.setContactWithCovidPatient(assessmentRequest.isContactWithCovidPatient());

         SelfAssessment userAssessment = (SelfAssessment) assessmentRepository.save(selfAssessment);

         String risk = riskCalculation(assessmentRequest.getSymptoms(),assessmentRequest.isTravelHistory(),assessmentRequest.isContactWithCovidPatient());

         return risk;
    }


    public String riskCalculation(String symptoms, boolean travelHistory, boolean contactWithCovidPatient){
    /*
    Risk Calculation:
No symptoms, No travel history, No contact with covid positive patient - Risk = 5%
Any one symptom, travel history or contact with covid positive patient is true - Risk = 50%
Any two symptoms, travel history or contact with covid positive patient is true - Risk = 75%
Greater than 2 symptoms, travel history or contact with covid positive patient is true - Risk = 95%

     */

        String riskPercentage="";

        String arr[] = symptoms.split(",");

        if ( contactWithCovidPatient || (arr  != null && arr.length==0 && !travelHistory)   ){
            riskPercentage = "5%";
        }else if ( contactWithCovidPatient||  (arr != null && arr.length ==1 && travelHistory)){
            riskPercentage = "50%";
        }else if ( contactWithCovidPatient ||  (arr !=null && arr.length ==2 && travelHistory)  )
            riskPercentage = "75%";
        else if ( contactWithCovidPatient ||  (arr != null && arr.length>2 && travelHistory) )
            riskPercentage = "95%";

        return riskPercentage;
    }




}
