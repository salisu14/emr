package com.sulbasoft.emr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private final PatientRepository repository = null;

    @GetMapping
    Iterable<Patient> all() {
        return repository.findAll();
    }
}
