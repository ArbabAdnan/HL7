package com.example.hl7.controllers;

import com.example.hl7.entities.Lab;
import com.example.hl7.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/labs")
public class LabController {

    private final LabService labService;

    @Autowired
    public LabController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping
    public List<Lab> getAllLabs() {
        return labService.getAllLabs();
    }

    @GetMapping("/{id}")
    public Lab getLabById(@PathVariable Long id) {
        return labService.getLabById(id)
                .orElseThrow(() -> new RuntimeException("Lab test not found"));
    }

    @PostMapping
    public Lab createLab(@RequestBody Lab lab) {
        return labService.createLab(lab);
    }

    @PutMapping("/{id}")
    public Lab updateLab(@PathVariable Long id, @RequestBody Lab updatedLab) {
        return labService.updateLab(id, updatedLab);
    }

    @DeleteMapping("/{id}")
    public void deleteLab(@PathVariable Long id) {
        labService.deleteLab(id);
    }
}

