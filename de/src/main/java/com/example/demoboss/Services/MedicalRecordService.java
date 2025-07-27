package com.example.demoboss.Services;

import com.example.demoboss.Model.MedicalRecord;
import com.example.demoboss.repositiry.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository reposs;

    public List<MedicalRecord> getAll() {
        return reposs.findAll();
    }

    public MedicalRecord save(MedicalRecord record) {
        return reposs.save(record);
    }

    public MedicalRecord getById(Long id) {
        return reposs.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Medical record not found with id: " + id
                ));
    }

    public MedicalRecord update(Long id, MedicalRecord updated) {
        MedicalRecord existing = getById(id);

        // Update fields
        existing.setPatient(updated.getPatient()); // set full Patient object
        existing.setDiagnosis(updated.getDiagnosis());
        existing.setTreatment(updated.getTreatment());
        existing.setDoctorNotes(updated.getDoctorNotes());

        return reposs.save(existing);
    }

    public String delete(Long id) {
        MedicalRecord existing = getById(id);
        reposs.deleteById(id);
        return "Medical record with ID " + id + " deleted.";
    }
}
