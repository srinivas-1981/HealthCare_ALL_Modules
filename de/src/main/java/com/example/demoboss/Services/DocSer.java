package com.example.demoboss.Services;

import com.example.demoboss.Model.Doctors;
import com.example.demoboss.repositiry.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class DocSer {
    @Autowired
     DocRepo repo;

    public Doctors saveDoctor(Doctors doctor) {
        return repo.save(doctor);
    }

    public List<Doctors> getAllDoctors() {
        return repo.findAll();
    }

    public Doctors getDoctorById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Doctor not found with ID: " + id));
    }

    public Doctors updateDoctor(Long id, Doctors newDoctor) {
        Doctors oldDoctor = getDoctorById(id);
        oldDoctor.setName(newDoctor.getName());
        oldDoctor.setSpecialization(newDoctor.getSpecialization());
        oldDoctor.setPhone(newDoctor.getPhone());
        oldDoctor.setEmail(newDoctor.getEmail());
        return repo.save(oldDoctor);
    }

    public void deleteDoctor(Long id) {
        repo.deleteById(id);
    }
}

