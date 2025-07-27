package com.example.demoboss.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Diagnosis is required")
    private String diagnosis;

    @NotBlank(message = "Treatment is required")
    private String treatment;

    private String doctorNotes;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    // Constructors
    public MedicalRecord() {}

    public MedicalRecord(Long id, String diagnosis, String treatment, String doctorNotes, Patient patient) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.doctorNotes = doctorNotes;
        this.patient = patient;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }

    public void setTreatment(String treatment) { this.treatment = treatment; }

    public String getDoctorNotes() { return doctorNotes; }

    public void setDoctorNotes(String doctorNotes) { this.doctorNotes = doctorNotes; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }
}
