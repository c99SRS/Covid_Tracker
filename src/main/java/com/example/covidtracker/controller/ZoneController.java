package com.example.covidtracker.controller;

import com.example.covidtracker.requestresponse.ZoneResponse;
import com.example.covidtracker.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @GetMapping
    @RequestMapping("/info/{pincode}")
    public ResponseEntity getZoneInfo(@PathVariable String pincode) {

        Map<String, String> response = new HashMap<>();
        if (null == pincode || pincode.isEmpty()) {
            response.put("error", "pincode is empty or null !!");
            response.put("status", HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        ZoneResponse zoneResponse = zoneService.getZoneInfo(pincode);

        if (zoneResponse == null)
            response.put("error","No data exist on this pinCode "+ pincode);
        else
            response.put("Success",zoneResponse.toString());

        response.put("status", HttpStatus.FOUND.toString());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

}
