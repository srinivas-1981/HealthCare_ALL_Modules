package com.example.demoboss.Controller;

import com.example.demoboss.Model.Billing;
import com.example.demoboss.Services.BillingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @PostMapping("/POSTING")
    public Billing save(@RequestBody @Valid Billing billing) {
        return service.save(billing);
    }

    @GetMapping("/GETTING")
    public List<Billing> getAll() {
        return service.getAll();
    }

    @GetMapping("/IDGET/{id}")
    public Billing getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/PUTID/{id}")
    public Billing update(@PathVariable Long id, @RequestBody @Valid Billing billing) {
        return service.update(id, billing);
    }

    @DeleteMapping("/DELEID/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}
