package com.enviro.assessment.grad001.mogafekoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mogafekoos.model.WasteCategory;
import com.enviro.assessment.grad001.mogafekoos.repository.WasteCategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {
    @Autowired
    WasteCategoryRepository wasteCategoryRepository;

    public List<WasteCategory> getAllWasteCategory() {
        return wasteCategoryRepository.findAll();
    }

    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        wasteCategory.setCreatedAt(LocalDateTime.now());
        wasteCategory.setUpdatedAt(LocalDateTime.now());
        return wasteCategoryRepository.save(wasteCategory);

    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedWasteCategory) {

        WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("waste category does not exists"));

        wasteCategory.setCategory(updatedWasteCategory.getCategory());
        wasteCategory.setUpdatedAt(LocalDateTime.now());

        return wasteCategoryRepository.save(wasteCategory);
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}