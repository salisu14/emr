package com.sulbasoft.emr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sulbasoft.emr.models.PatientEntity;
import com.sulbasoft.emr.repositories.PatientEntityRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;  // main one


@DataJpaTest
public class PatientEntityTest {
    
    @Autowired
    PatientEntityRepository repository;

    @Test
    void testSavePatientEntity() {
        PatientEntity patient = repository.save(new PatientEntity.Builder()
        .id(1L)
        .firstName("Muhammad S")
        .lastName("Ali")
        .build());

        // assertEquals(patient.getId(), 1);

        //  assertThat(patient.getId()).isNotNull();
        assertThat(patient.getId()).isNotNull();
    }

    @Test
    void testListingPatients() {
        PatientEntity patient1 = new PatientEntity.Builder()
            .id(1L)
            .firstName("Muhammad S")
            .lastName("Ali")
            .build();

        PatientEntity patient2 = new PatientEntity.Builder()
            .id(2L)
            .firstName("Zainab M")
            .lastName("Salisu")
            .build();

        List<PatientEntity> patients = List.of(patient1, patient2);

        repository.saveAll(patients);

        assertEquals(patients.size(), repository.count());
        assertThat(repository.count()).isEqualTo(patients.size());
    }
}
