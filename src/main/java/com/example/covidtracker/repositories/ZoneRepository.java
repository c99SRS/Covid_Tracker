package com.example.covidtracker.repositories;

import com.example.covidtracker.model.Zone;
import org.springframework.data.repository.CrudRepository;

public interface ZoneRepository extends CrudRepository<Zone,Integer> {

    Zone findZoneByPinCode(String pinCode);

}
