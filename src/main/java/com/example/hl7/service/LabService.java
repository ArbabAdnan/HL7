package com.example.hl7.service;

import com.example.hl7.entities.Lab;

import java.util.List;
import java.util.Optional;

public interface LabService {
    List<Lab> getAllLabs();
    Optional<Lab> getLabById(Long id);
    Lab createLab(Lab lab);
    Lab updateLab(Long id, Lab lab);
    void deleteLab(Long id);
}
