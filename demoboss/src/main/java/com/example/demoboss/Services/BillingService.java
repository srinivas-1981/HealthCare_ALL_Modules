package com.example.demoboss.Services;

import com.example.demoboss.Model.Billing;
import com.example.demoboss.Model.Patient;
import com.example.demoboss.repositiry.BillingRepository;
import com.example.demoboss.repositiry.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repo;

    @Autowired
    private PatientRepo patientRepo;

    public Billing save(Billing billing) {
        Long patientId = billing.getPatient().getId();

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Patient not found with ID: " + patientId
                ));

        billing.setPatient(patient);
        return repo.save(billing);
    }

    public List<Billing> getAll() {
        return repo.findAll();
    }

    public Billing getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Billing not found with ID: " + id
                ));
    }

    public Billing update(Long id, Billing billing) {
        Billing existing = getById(id);

        Long patientId = billing.getPatient().getId();
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Patient not found with ID: " + patientId
                ));

        existing.setPatient(patient);
        existing.setAmount(billing.getAmount());
        existing.setBillingDate(billing.getBillingDate());
        existing.setStatus(billing.getStatus());

        return repo.save(existing);
    }

    public void delete(Long id) {
        Billing existing = getById(id);
        repo.delete(existing);
    }
}
