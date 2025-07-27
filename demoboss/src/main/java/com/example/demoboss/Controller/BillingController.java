package com.example.demoboss.Controller;

import com.example.demoboss.Model.Billing;
import com.example.demoboss.repositiry.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    // Create new billing entry
    @PostMapping("/POSTT")
    public Billing createBilling(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }

    // Get all billing records
    @GetMapping("/GETTT")
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    // Get a single billing by ID
    @GetMapping("/gets/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) {
        Optional<Billing> billing = billingRepository.findById(id);
        return billing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update billing by ID
    @PutMapping("/puts/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long id, @RequestBody Billing updatedBilling) {
        return billingRepository.findById(id).map(existing -> {
            existing.setBillingDate(updatedBilling.getBillingDate());
            existing.setAmount(updatedBilling.getAmount());
            existing.setDescription(updatedBilling.getDescription());
            existing.setPatient(updatedBilling.getPatient());
            existing.setStatus(updatedBilling.getStatus());
            return ResponseEntity.ok(billingRepository.save(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete billing by ID
    @DeleteMapping("/delts/{id}")
    public ResponseEntity<Object> deleteBilling(@PathVariable Long id) {
        return billingRepository.findById(id).map(billing -> {
            billingRepository.delete(billing);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
