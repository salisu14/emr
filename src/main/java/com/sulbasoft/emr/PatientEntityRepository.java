package com.sulbasoft.emr;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientEntityRepository extends CrudRepository<PatientEntity, Long> {
    
}
