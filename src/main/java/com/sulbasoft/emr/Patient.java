package com.sulbasoft.emr;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Patient( @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
    String firstName,
    String lastName,
    LocalDate birthDate,
    Gender gender
) {

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private Gender gender;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Patient build() {
            return new Patient(id, firstName, lastName, birthDate, gender);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
    
}
