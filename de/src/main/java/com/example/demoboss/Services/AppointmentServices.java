package com.example.demoboss.Services;

import com.example.demoboss.Model.Appointment;
import com.example.demoboss.Model.Patient;
import com.example.demoboss.Model.Doctors;
import com.example.demoboss.repositiry.AppointmentRepository;
import com.example.demoboss.repositiry.PatientRepo;
import com.example.demoboss.repositiry.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AppointmentServices {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepo patientRepository;

    @Autowired
    private DocRepo doctorRepository;

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Save new appointment
    public Appointment save(Appointment appointment) {
        Long patientId = appointment.getPatient().getId();
        Long doctorId = appointment.getDoctor().getId();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Patient not found with id: " + patientId
                ));

        Doctors doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Doctor not found with id: " + doctorId
                ));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    // Get by ID
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Appointment not found with id: " + id
                ));
    }

    // Update appointment
    public Appointment update(Long id, Appointment updated) {
        Appointment existing = getById(id);

        existing.setAppointmentDate(updated.getAppointmentDate());
        existing.setReason(updated.getReason());

        Long newPatientId = updated.getPatient().getId();
        Long newDoctorId = updated.getDoctor().getId();

        Patient patient = patientRepository.findById(newPatientId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Patient not found with id: " + newPatientId
                ));

        Doctors doctor = doctorRepository.findById(newDoctorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Doctor not found with id: " + newDoctorId
                ));

        existing.setPatient(patient);
        existing.setDoctor(doctor);

        return appointmentRepository.save(existing);
    }

    // Delete
    public String delete(Long id) {
        Appointment existing = getById(id);
        appointmentRepository.deleteById(id);
        return "Appointment with ID " + id + " deleted successfully.";
    }
}
