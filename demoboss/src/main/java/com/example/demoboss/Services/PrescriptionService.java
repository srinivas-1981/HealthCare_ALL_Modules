package com.example.demoboss.Services;

import com.example.demoboss.Model.Prescription;
import com.example.demoboss.repositiry.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository repo;

    public Prescription save(Prescription p) {
        return repo.save(p);
    }

    public List<Prescription> getAll() {
        return repo.findAll();
    }

    public Prescription getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Prescription update(Long id, Prescription updated) {
        Prescription old = repo.findById(id).orElseThrow();
        old.setPatientId(updated.getPatientId());
        old.setDoctorId(updated.getDoctorId());
        old.setMedicines(updated.getMedicines());
        old.setInstructions(updated.getInstructions());
        return repo.save(old);
    }
}
