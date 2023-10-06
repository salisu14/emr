package com.sulbasoft.emr.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sulbasoft.emr.models.PatientEntity;
import com.sulbasoft.emr.repositories.PatientEntityRepository;

@Service
public class PatientService {

    private final PatientEntityRepository repository;

    public PatientService(PatientEntityRepository repository) {
        this.repository = repository;
    }

    public Long count() {
        return repository.count();
    }

    public List<PatientEntity> getAll() {
        return repository.findAll();
    }

    public List<PatientEntity> saveAllPatients(Iterable<PatientEntity> patients) {
        return repository.saveAll(patients);
    }

    public List<PatientEntity> search(PatientEntity patientEntity) {
        if(StringUtils.hasText(patientEntity.getFirstName()) && StringUtils.hasText(patientEntity.getLastName())) {
            return repository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(patientEntity.getFirstName(), patientEntity.getLastName());
        }

        if (StringUtils.hasText(patientEntity.getFirstName())) {
            return repository.findByFirstNameContainsIgnoreCase(patientEntity.getFirstName());
        }

        if (StringUtils.hasText(patientEntity.getLastName())) {
            return repository.findByLastNameContainsIgnoreCase(patientEntity.getLastName());
        }

        return Collections.emptyList();
    }

    public List<PatientEntity> searchPatients(String firstName, String lastName) {
        // Create an example patient with the provided attributes
        PatientEntity examplePatient = new PatientEntity();
        examplePatient.setFirstName(firstName);
        examplePatient.setLastName(lastName);

        // Define a matcher to specify how to match attributes (e.g., ignoring case)
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withMatcher("firstName", match -> match.contains())
                .withMatcher("lastName", match -> match.contains());

        // Create an Example using the example patient and matcher
        Example<PatientEntity> example = Example.of(examplePatient, matcher);

        // Use the repository to find entities that match the example
        return repository.findAll(example);
    }

    public List<PatientEntity> performFullTextSearch(String query) {
        List<PatientEntity> matchingPatients = this.getAll().stream()
            .filter(patient ->
                patient.getFirstName().toLowerCase().contains(query.toLowerCase()) ||
                patient.getLastName().toLowerCase().contains(query.toLowerCase()) ||
                patient.getGender().toString().toLowerCase().contains(query.toLowerCase()) ||
                patient.getBirthDate().toString().contains(query)
            ).collect(Collectors.toList());
        
        return matchingPatients;
    }
}