package com.sulbasoft.emr.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulbasoft.emr.models.PatientEntity;
import com.sulbasoft.emr.repositories.PatientEntityRepository;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
   
    private final PatientEntityRepository repository;
 
    @Autowired
    public PatientController(PatientEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<PatientEntity> all() {
        System.out.println( repository.findAll());
        return repository.findAll();
    }

    @GetMapping("/search")
    public List<PatientEntity> search(PatientEntity patientEntity) {
        if(StringUtils.hasText(patientEntity.getFirstName()) && StringUtils.hasText(patientEntity.getLastName())) {
            return repository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(patientEntity.getFirstName(), patientEntity.getLastName());
        }

        if (StringUtils.hasText(patientEntity.getFirstName())) {
            return repository.findByFirstNameContainsIgnoreCase(patientEntity.getFirstName());
        }

        if (StringUtils.hasText(patientEntity.getFirstName())) {
            return repository.findByLastNameContainsIgnoreCase(patientEntity.getFirstName());
        }

        return null;
    }
}
