package com.example.demoboss.repositiry;

import com.example.demoboss.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}

