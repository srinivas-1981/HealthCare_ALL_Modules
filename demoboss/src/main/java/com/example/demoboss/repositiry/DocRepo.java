package com.example.demoboss.repositiry;

import com.example.demoboss.Model.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepo extends JpaRepository<Doctors, Long> {
}
