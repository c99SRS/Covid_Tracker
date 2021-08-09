package com.example.covidtracker.controller;


import com.example.covidtracker.model.UserCovidResult;
import com.example.covidtracker.requestresponse.*;
import com.example.covidtracker.service.AdminService;
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
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping(path = "/register")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest){
        Map<String, String> response = new HashMap<>();
        if (null == userRequest){
            response.put("error", "userrequest object is null !!");
            response.put("status", HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Integer adminId = adminService.createAdmin(userRequest);
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setAdminId(adminId);

        response.put("Success",adminResponse.toString());
        response.put("status", HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Sample request - {"userId":"1","adminId":"2","result":"positive"}
    //Sample response - {"updated":true}

    @PostMapping(path="/enterresult")
    public ResponseEntity registerCovidPatient(@RequestBody CovidReultRequest covidReultRequest){

        Map<String, String> response = new HashMap<>();
        if (null == covidReultRequest){
            response.put("error", "covidReultRequest object is null !!");
            response.put("status", HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }


        UserCovidResult userCovidResult = adminService.enterUserCovidResult(covidReultRequest);

        CovidResponse covidResponse = new CovidResponse();
        if (userCovidResult.getId() > 0)
             covidResponse.setUpdated(true);

        response.put("Success",covidResponse.toString());
        response.put("status", HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }





}
