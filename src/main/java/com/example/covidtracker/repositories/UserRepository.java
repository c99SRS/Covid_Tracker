package com.example.covidtracker.repositories;

import com.example.covidtracker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
