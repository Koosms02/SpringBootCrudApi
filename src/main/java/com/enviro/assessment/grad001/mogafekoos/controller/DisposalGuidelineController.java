package com.enviro.assessment.grad001.mogafekoos.controller;

import com.enviro.assessment.grad001.mogafekoos.model.DisposalGuideline;
import com.enviro.assessment.grad001.mogafekoos.service.DisposalGuidelineService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disposal-guideline")
@Validated
public class DisposalGuidelineController {

    @Autowired
    DisposalGuidelineService disposalGuidelineService;

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuideline() {

        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuideline();

        return new ResponseEntity<>(disposalGuidelines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {

        Optional<DisposalGuideline> disposalGuideline = disposalGuidelineService.getDisposalGuidelineById(id);
        if (disposalGuideline.isPresent()) {
            return new ResponseEntity<>(disposalGuideline.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(
            @Validated @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdDisposalGuideline = disposalGuidelineService
                .createDisposalGuideline(disposalGuideline);

        return new ResponseEntity<>(createdDisposalGuideline, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @Validated @RequestBody DisposalGuideline updatedGuideline,
            @PathVariable Long id) {

        try {
            DisposalGuideline updatedDisposalGuide = disposalGuidelineService.updateDisposalGuideline(id,
                    updatedGuideline);

            return ResponseEntity.ok(updatedDisposalGuide);

            // return new ResponseEntity<>(updatedDisposalGuide, HttpStatus.OK);

        } catch (RuntimeException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        try {
            disposalGuidelineService.deleteDisposalGuideline(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}