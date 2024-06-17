package com.enviro.assessment.grad001.mogafekoos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.mogafekoos.model.WasteCategory;
import com.enviro.assessment.grad001.mogafekoos.service.WasteCategoryService;

@RestController
@RequestMapping("/waste-category")

public class WasteCategoryController {

    @Autowired
    WasteCategoryService wasteCategoryService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategory() {
        List<WasteCategory> wasteCategories = wasteCategoryService.getAllWasteCategory();
        return new ResponseEntity<>(wasteCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> wasteCategory = wasteCategoryService.getWasteCategoryById(id);
        if (wasteCategory.isPresent()) {
            return new ResponseEntity<>(wasteCategory.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategoty(@Validated @RequestBody WasteCategory wasteCategory) {

        WasteCategory createdWasteCategory = wasteCategoryService
                .createWasteCategory(wasteCategory);

        return new ResponseEntity<>(createdWasteCategory, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id,
            @Validated @RequestBody WasteCategory updatedWastecategory) {
        try {
            WasteCategory wasteCategory = wasteCategoryService.updateWasteCategory(id, updatedWastecategory);
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        try {
            wasteCategoryService.deleteWasteCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
