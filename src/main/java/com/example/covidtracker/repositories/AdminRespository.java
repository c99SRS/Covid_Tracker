package com.example.covidtracker.repositories;

import com.example.covidtracker.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRespository extends CrudRepository<Admin,Integer> {
}
