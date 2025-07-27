package com.example.demoboss.Controller;

import com.example.demoboss.Model.Doctors;
import com.example.demoboss.Services.DocSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocController {
    @Autowired
    private DocSer service;

    @PostMapping("/postt")
    public Doctors createDoctor(@RequestBody Doctors doctor) {
        return service.saveDoctor(doctor);
    }

    @GetMapping("/gett")
    public List<Doctors> getAllDoctors() {
        return service.getAllDoctors();
    }

    @GetMapping("/gett/{id}")
    public Doctors getDoctorById(@PathVariable Long id) {
        return service.getDoctorById(id);
    }

    @PutMapping("/putt/{id}")
    public Doctors updateDoctor(@PathVariable Long id, @RequestBody Doctors doctor) {
        return service.updateDoctor(id, doctor);
    }

    @DeleteMapping("/delett/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
    }

}
