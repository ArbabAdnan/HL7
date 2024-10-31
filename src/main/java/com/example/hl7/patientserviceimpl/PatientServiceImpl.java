package com.example.hl7.patientserviceimpl;

import com.example.hl7.entities.Patient;
import com.example.hl7.patientService.PatientService;
import com.example.hl7.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(updatedPatient.getFirstName());
                    patient.setLastName(updatedPatient.getLastName());
                    patient.setEmail(updatedPatient.getEmail());
                    patient.setPhoneNumber(updatedPatient.getPhoneNumber());
                    patient.setGender(updatedPatient.getGender());
                    patient.setAddress(updatedPatient.getAddress());
                    patient.setCity(updatedPatient.getCity());
                    patient.setState(updatedPatient.getState());
                    patient.setCountry(updatedPatient.getCountry());
                    patient.setPostalCode(updatedPatient.getPostalCode());
                    patient.setEmergencyContactName(updatedPatient.getEmergencyContactName());
                    patient.setEmergencyContactPhone(updatedPatient.getEmergencyContactPhone());
                    patient.setBloodGroup(updatedPatient.getBloodGroup());
                    patient.setMedicalHistory(updatedPatient.getMedicalHistory());
                    patient.setActive(updatedPatient.getActive());
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
