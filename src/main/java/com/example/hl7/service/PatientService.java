package com.example.hl7.service;

import com.example.hl7.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}

