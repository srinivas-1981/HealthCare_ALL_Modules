package com.example.demoboss.Controller;

import com.example.demoboss.Model.Patient;
import com.example.demoboss.Services.PatientSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientSer service;

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return service.savePatient(patient);
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}
