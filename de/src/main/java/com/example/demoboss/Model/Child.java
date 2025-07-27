package com.example.demoboss.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Entity
public class Child  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "pls enter your name")
    private String name;

    @Min(value = 1,message = "your age should be atleast more then 1")
    @Max(value = 18,message = "your age should not excced from 18")
    private int age;

    @NotBlank(message = "the gender is required")
    private String gender;

    @NotBlank(message = "the parent contact number is required")
    @Pattern(regexp = "\\d{10}", message = "Parent contact must be 10 digits")
    private String parentContact;

    @NotBlank(message = "Address is required")
    private String address;

    private String medicalHistory;

    @ManyToOne
    @JoinColumn(name = "patient_id") // foreign key column
    private Patient patient;

    public Child(Patient patient, String medicalHistory, String address, String parentContact, String gender, int age, String name, long id) {
        this.patient = patient;
        this.medicalHistory = medicalHistory;
        this.address = address;
        this.parentContact = parentContact;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Child() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getParentContact() {
        return parentContact;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
