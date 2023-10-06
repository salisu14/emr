package com.sulbasoft.emr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sulbasoft.emr.models.PatientEntity;

@Repository
public interface PatientEntityRepository extends CrudRepository<PatientEntity, Long> {
    
}
