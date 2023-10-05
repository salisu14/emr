package com.sulbasoft.emr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final PatientEntityRepository repository = null;

    @Override
    public void run(String... args) throws Exception {

        // Create an empty list to store PatientEntity objects
        List<PatientEntity> patients = new ArrayList<>();

        PatientEntity patient = new PatientEntity.Builder()
            .id(1L)
            .firstName("MS")
            .lastName("Ali")
            .birthDate(LocalDate.of(1980, 4, 15))
            .gender(Gender.MALE)
            .build();

        PatientEntity patient1 = new PatientEntity.Builder()
            .id(1L)
            .firstName("Abubakar M.")
            .lastName("Hussaini")
            .birthDate(LocalDate.of(1990, 5, 15))
            .gender(Gender.MALE)
            .build();

        PatientEntity patient2 = new PatientEntity.Builder()
            .id(1L)
            .firstName("Ibrahim")
            .lastName("Safiyanu")
            .birthDate(LocalDate.of(1995, 7, 25))
            .gender(Gender.MALE)
            .build();

        PatientEntity patient3 = new PatientEntity.Builder()
            .id(1L)
            .firstName("Jamila Umar")
            .lastName("Bala")
            .birthDate(LocalDate.of(1996, 3, 5))
            .gender(Gender.FEMALE)
            .build();

        PatientEntity patient4 = new PatientEntity.Builder()
            .id(1L)
            .firstName("Jamila")
            .lastName("Hassan")
            .birthDate(LocalDate.of(1993, 11, 20))
            .gender(Gender.FEMALE)
            .build();

        patients.add(patient);
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);

        repository.saveAll(patients);
    }
    
}
