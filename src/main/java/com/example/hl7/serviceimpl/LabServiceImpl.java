package com.example.hl7.serviceimpl;

import com.example.hl7.entities.Lab;
import com.example.hl7.repositories.LabRepository;
import com.example.hl7.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LabServiceImpl implements LabService {

    private final LabRepository labRepository;

    @Autowired
    public LabServiceImpl(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    @Override
    public List<Lab> getAllLabs() {
        return labRepository.findAll();
    }

    @Override
    public Optional<Lab> getLabById(Long id) {
        return labRepository.findById(id);
    }

    @Override
    public Lab createLab(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public Lab updateLab(Long id, Lab updatedLab) {
        return labRepository.findById(id)
                .map(lab -> {
                    lab.setTestName(updatedLab.getTestName());
                    lab.setTestDate(updatedLab.getTestDate());
                    lab.setResult(updatedLab.getResult());
                    lab.setComments(updatedLab.getComments());
                    lab.setPatient(updatedLab.getPatient());
                    return labRepository.save(lab);
                })
                .orElseThrow(() -> new RuntimeException("Lab test not found"));
    }

    @Override
    public void deleteLab(Long id) {
        labRepository.deleteById(id);
    }
}
