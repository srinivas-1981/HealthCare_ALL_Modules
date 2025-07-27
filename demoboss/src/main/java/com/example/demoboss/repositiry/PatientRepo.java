package com.example.demoboss.repositiry;

import com.example.demoboss.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
