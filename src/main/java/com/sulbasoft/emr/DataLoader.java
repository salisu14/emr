package com.sulbasoft.emr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientEntityRepository repository;

    public DataLoader(PatientEntityRepository repository) {
        this.repository = repository;
    }

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
            .id(2L)  // Unique id for patient1
            .firstName("Abubakar M.")
            .lastName("Hussaini")
            .birthDate(LocalDate.of(1990, 5, 15))
            .gender(Gender.MALE)
            .build();

        PatientEntity patient2 = new PatientEntity.Builder()
            .id(3L)  // Unique id for patient2
            .firstName("Ibrahim")
            .lastName("Safiyanu")
            .birthDate(LocalDate.of(1995, 7, 25))
            .gender(Gender.MALE)
            .build();

        PatientEntity patient3 = new PatientEntity.Builder()
            .id(4L)  // Unique id for patient3
            .firstName("Jamila Umar")
            .lastName("Bala")
            .birthDate(LocalDate.of(1996, 3, 5))
            .gender(Gender.FEMALE)
            .build();

        PatientEntity patient4 = new PatientEntity.Builder()
            .id(5L)  // Unique id for patient4
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

        for (PatientEntity p : patients) {
            repository.save(p);
        }

        System.out.println("In Bootstrap");
        System.out.println("Patient counts: " + repository.count());
    }
    
}
