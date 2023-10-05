package com.sulbasoft.emr;

import org.springframework.data.repository.CrudRepository;

public interface PatientEntityRepository extends CrudRepository<PatientEntity, Long> {
    
}
