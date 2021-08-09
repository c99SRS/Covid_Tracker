package com.example.covidtracker.repositories;

import com.example.covidtracker.model.UserCovidResult;
import org.springframework.data.repository.CrudRepository;

public interface UserCovidResultRepository extends CrudRepository<UserCovidResult,Integer> {
}
