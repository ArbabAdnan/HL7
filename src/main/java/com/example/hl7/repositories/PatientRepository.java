package com.example.hl7.repositories;

import com.example.hl7.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Custom queries can be added here if needed
}

