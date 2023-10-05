# emr
Simple Electronic Medical Record

## This is a simple Electronic Medical Record Design for teaching purposes.
* The project would be developed incrementally adding new features

## Planned Entities to be used in the EMR database:

### Patients:
* PatientID (Primary Key)
* FirstName
* LastName
* DateOfBirth
* Gender
* Contact Information (Address, Phone, Email)

### Providers:
* ProviderID (Primary Key)
* FirstName
* LastName
* Specialization
* Contact Information (Address, Phone, Email)

### Encounters:
* EncounterID (Primary Key)
* PatientID (Foreign Key)
* ProviderID (Foreign Key)
* Date
* Type (e.g., outpatient, inpatient)
* Notes

### Diagnoses:
* DiagnosisID (Primary Key)
* EncounterID (Foreign Key)
* DiagnosisCode (e.g., SNOMED CT)
* Description
* Date

### Medications:
* MedicationID (Primary Key)
* PatientID (Foreign Key)
* MedicationName
* Dosage
* PrescriptionDate
* StartDate
* EndDate

### Procedures:
* ProcedureID (Primary Key)
* EncounterID (Foreign Key)
* ProcedureCode (e.g., CPT)
* Description
* Date

### LabResults:
* LabResultID (Primary Key)
* EncounterID (Foreign Key)
* TestName
* ResultValue
* Units
* ReferenceRange
* Date

### ImagingStudies:
* ImagingStudyID (Primary Key)
* EncounterID (Foreign Key)
* StudyType
* StudyDate
* Report (could be a reference to a separate table for detailed reports)