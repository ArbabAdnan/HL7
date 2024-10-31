package com.example.hl7.repositories;

import com.example.hl7.entities.Lab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {
    // Additional custom queries can be added here if needed
}
