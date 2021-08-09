package com.example.covidtracker.service;


import com.example.covidtracker.model.Zone;
import com.example.covidtracker.repositories.ZoneRepository;
import com.example.covidtracker.requestresponse.ZoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    public ZoneResponse getZoneInfo(String pincode) {

        Zone zone = zoneRepository.findZoneByPinCode(pincode);

        if (zone == null)
            return null;

        String zoneSeverity = findZoneSeverity(zone);
        ZoneResponse zoneResponse = new ZoneResponse();
        zoneResponse.setNumOfCases(String.valueOf(zone.getNoOfCases()));
        zoneResponse.setZoneType(zoneSeverity);


        return zoneResponse;
    }

    private String findZoneSeverity(Zone zone) {

        if (zone.getNoOfCases() < 5)
            return "ORANGE";
        else if (zone.getNoOfCases() > 5)
            return "RED";
        else
            return "GREEN";
    }


}
