package com.example.demoboss.Services;

import com.example.demoboss.Model.Patient;
import com.example.demoboss.repositiry.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PatientSer {

    @Autowired
    private PatientRepo repo;

    public Patient savePatient(Patient patient) {
        return repo.save(patient);
    }

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Patient getPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found with ID: " + id));
    }

    public Patient updatePatient(Long id, Patient newPatient) {
        Patient existing = getPatientById(id);
//        existing.setName(newPatient.getName());
//        existing.setAge(newPatient.getAge());
//        existing.setGender(newPatient.getGender());
//        existing.setPhone(newPatient.getPhone());
//        existing.setEmail(newPatient.getEmail());
        return repo.save(existing);
    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
}
