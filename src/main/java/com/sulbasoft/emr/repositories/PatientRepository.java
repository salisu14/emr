package com.sulbasoft.emr.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sulbasoft.emr.models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    
}
