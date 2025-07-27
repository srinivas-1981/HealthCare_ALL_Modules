package com.example.demoboss.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotBlank(message = "Medicines must not be blank")
    @Size(min = 2, max = 200, message = "Medicines should be between 2 and 200 characters")
    private String medicines;

    @NotBlank(message = "Instructions must not be blank")
    @Size(min = 5, max = 300, message = "Instructions should be between 5 and 300 characters")
    private String instructions;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}
