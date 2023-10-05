# emr
Simple Electronic Medical Record

## This is a simple Electronic Medical Record Design for teaching purposes.
* The project would be developed incrementally adding more features

## Planned Entities to be used in the EMR database:

### Patients:
- PatientID (Primary Key)
- FirstName
- LastName
- DateOfBirth
- Gender
- Contact Information (Address, Phone, Email)

### Providers:
- ProviderID (Primary Key)
- FirstName
- LastName
- Specialization
- Contact Information (Address, Phone, Email)

### Encounters:
- EncounterID (Primary Key)
- PatientID (Foreign Key)
- ProviderID (Foreign Key)
- Date
- Type (e.g., outpatient, inpatient)
- Notes

### Diagnoses:
- DiagnosisID (Primary Key)
- EncounterID (Foreign Key)
- DiagnosisCode (e.g., SNOMED CT)
- Description
- Date

### Medications:
- MedicationID (Primary Key)
- PatientID (Foreign Key)
- MedicationName
- Dosage
- PrescriptionDate
- StartDate
- EndDate

### Procedures:
- ProcedureID (Primary Key)
- EncounterID (Foreign Key)
- ProcedureCode (e.g., CPT)
- Description
- Date

### LabResults:
- LabResultID (Primary Key)
- EncounterID (Foreign Key)
- TestName
- ResultValue
- Units
- ReferenceRange
- Date

### ImagingStudies:
- ImagingStudyID (Primary Key)
- EncounterID (Foreign Key)
- StudyType
- StudyDate
- Report (could be a reference to a separate table for detailed reports)

### Running The Project
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open STS/Eclipse
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the right project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application
- You are all Set