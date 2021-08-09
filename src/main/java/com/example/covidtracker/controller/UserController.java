package com.example.covidtracker.controller;


import com.example.covidtracker.requestresponse.AssessmentRequest;
import com.example.covidtracker.requestresponse.AssessmentResponse;
import com.example.covidtracker.requestresponse.UserRequest;
import com.example.covidtracker.requestresponse.UserResponse;
import com.example.covidtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    //register user
    // registerUser:
    //Sample request - {"name":"A","phoneNumber":"9999999999","pinCode":"111111"}

    @PostMapping(path="/register")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest){

        Map<String, String> response = new HashMap<>();
        if (null == userRequest){
            response.put("error", "userrequest object is null !!");
            response.put("status", HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Integer userId = userService.createUser(userRequest);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userId);


        response.put("Success",userResponse.toString());
        response.put("status", HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //selfAssessment:
   // Sample request - {"userId":"1","symptoms":["fever","cold","cough"],"travelHistory":true,"contactWithCovidPatient":true}
   // Sample response - {"riskPercentage": 95}

    @PostMapping(path="/selfassessment")
    public ResponseEntity registerAssessment(@RequestBody AssessmentRequest assessmentRequest){

        Map<String, String> response = new HashMap<>();
        if (null == assessmentRequest ){
            response.put("error", "assessmentRequest object is null !!");
            response.put("status", HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }


        String riskPercentage = userService.createUserAssessment(assessmentRequest);
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setRiskPercentage(riskPercentage);

        response.put("Success",assessmentResponse.toString());
        response.put("status", HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }






}
