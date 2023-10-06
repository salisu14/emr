package com.sulbasoft.emr.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sulbasoft.emr.models.PatientEntity;
import com.sulbasoft.emr.services.PatientService;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
   
    private final PatientService service;
 
    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    Iterable<PatientEntity> all() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<PatientEntity> search(PatientEntity patientEntity) {
        return service.search(patientEntity);
    }

    @GetMapping("/universal-search")
    public  List<PatientEntity> universalSearch(String firstName, String lastName) {
        return service.searchPatients(firstName, lastName);
    }

    @GetMapping("/fulltext-search")
    public List<PatientEntity> search(@RequestParam String query) {
        return service.performFullTextSearch(query);
    }
}
