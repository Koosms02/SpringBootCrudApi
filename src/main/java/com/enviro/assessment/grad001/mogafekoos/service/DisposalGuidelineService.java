package com.enviro.assessment.grad001.mogafekoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mogafekoos.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.mogafekoos.model.DisposalGuideline;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    DisposalGuidelineRepository disposalGuidelineRepository;

    public List<DisposalGuideline> getAllDisposalGuideline() {
        return disposalGuidelineRepository.findAll();
    }

    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    public DisposalGuideline createDisposalGuideline(DisposalGuideline disposalGuideline) {

        disposalGuideline.setCreatedAt(LocalDateTime.now());
        disposalGuideline.setUpdatedAt(LocalDateTime.now());
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedDisposalGuideline) {
        // error handling
        DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id).orElseThrow(
                () -> new RuntimeException("disposal guideline NOT_FOUND"));

        disposalGuideline.setUpdatedAt(LocalDateTime.now());

        disposalGuideline.setGuideline(updatedDisposalGuideline.getGuideline());

        return disposalGuidelineRepository.save(disposalGuideline);
    }

    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }

}
