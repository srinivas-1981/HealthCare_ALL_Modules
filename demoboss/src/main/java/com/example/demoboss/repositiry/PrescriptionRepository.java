package com.example.demoboss.repositiry;
import com.example.demoboss.Model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
