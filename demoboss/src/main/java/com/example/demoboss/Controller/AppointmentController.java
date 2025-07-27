package com.example.demoboss.Controller;

import com.example.demoboss.Model.Appointment;
import com.example.demoboss.Services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentServices appo;

    @GetMapping("/ge")
    public List<Appointment> getalltheappointMent(){
        return appo.getAllAppointments();
    }

    @PostMapping("/pos")
    public Appointment save(@RequestBody Appointment appointment) {
        return appo.save(appointment);
    }
    @GetMapping("/ge/{id}")
    public Appointment AppointmentController(@PathVariable Long id) {
        return appo.getById(id);
    }
    @PutMapping("/pu/{id}")
    public Appointment update(@PathVariable Long id, @RequestBody Appointment updated) {
        return appo.update(id, updated);
    }
    @DeleteMapping("/deleting/{id}")
    public String Deleting(@PathVariable("id") long id){
        return appo.delete(id);
    }
}
