package com.example.demoboss.Controller;

import com.example.demoboss.Model.Prescription;
import com.example.demoboss.Services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    @PostMapping("/POST")
    public Prescription save(@RequestBody Prescription p) {
        return service.save(p);
    }

    @GetMapping("/GET")
    public List<Prescription> getAll() {
        return service.getAll();
    }

    @GetMapping("/GETI/{id}")
    public Prescription getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("DELET/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Prescription with id " + id;
    }

    @PutMapping("PUTING/{id}")
    public Prescription update(@PathVariable Long id, @RequestBody Prescription p) {
        return service.update(id, p);
    }
}
