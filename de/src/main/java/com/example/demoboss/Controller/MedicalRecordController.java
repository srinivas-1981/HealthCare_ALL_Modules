package com.example.demoboss.Controller;

import com.example.demoboss.Model.MedicalRecord;
import com.example.demoboss.Services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/medical-records")
//@CrossOrigin(origins = "http://localhost:5173")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping("/G")
    public List<MedicalRecord> getAll() {
        return service.getAll();
    }

    @PostMapping("/P")
    public MedicalRecord save(@RequestBody MedicalRecord record) {
        return service.save(record);
    }

    @GetMapping("/G/{id}")
    public MedicalRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/PU/{id}")
    public MedicalRecord update(@PathVariable Long id, @RequestBody MedicalRecord record) {
        return service.update(id, record);
    }

    @DeleteMapping("/D/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
