package com.sulbasoft.emr.models;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String label;

    private Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
