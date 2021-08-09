package com.example.covidtracker.repositories;

import com.example.covidtracker.model.SelfAssessment;
import org.springframework.data.repository.CrudRepository;

public interface SelfAssessmentRepository extends CrudRepository<SelfAssessment,Integer> {
}
