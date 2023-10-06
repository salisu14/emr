package com.sulbasoft.emr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulbasoft.emr.models.PatientEntity;

@Repository
public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String firstName, String lastName);

    List<PatientEntity> findByFirstNameContainsIgnoreCase(String firstName);

    List<PatientEntity> findByLastNameContainsIgnoreCase(String lastName);
}
