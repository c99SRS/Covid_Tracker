package com.example.covidtracker.service;

import com.example.covidtracker.model.Admin;
import com.example.covidtracker.model.UserCovidResult;
import com.example.covidtracker.repositories.AdminRespository;
import com.example.covidtracker.repositories.UserCovidResultRepository;
import com.example.covidtracker.requestresponse.CovidReultRequest;
import com.example.covidtracker.requestresponse.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRespository adminRespository;

    @Autowired
    UserCovidResultRepository userCovidResultRepository;

    public Integer createAdmin(UserRequest userRequest) {

        Admin admin = new Admin();
        admin.setName(userRequest.getName());
        admin.setPhoneNumber(userRequest.getPhoneNo());
        admin.setPinCode(userRequest.getPinCode());

        Admin newAdmin = (Admin) adminRespository.save(admin);

        return newAdmin.getId();
    }


    public UserCovidResult enterUserCovidResult(CovidReultRequest covidReultRequest) {

        UserCovidResult userCovidResult = new UserCovidResult();
        userCovidResult.setUserId(covidReultRequest.getUserId());
        userCovidResult.setAdminId(covidReultRequest.getAdminId());
        userCovidResult.setUserResult(covidReultRequest.getResult());

        UserCovidResult result = (UserCovidResult) userCovidResultRepository.save(userCovidResult);

        return result;
    }





}
