package com.enviro.assessment.grad001.mogafekoos.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.mogafekoos.model.RecyclingTip;
import com.enviro.assessment.grad001.mogafekoos.service.RecyclingTipService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycling-tip")
@Validated
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecuTips() {
        List<RecyclingTip> recyclingTip = recyclingTipService.getAllRecyclingTips();

        return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipsById(@PathVariable Long id) {
        Optional<RecyclingTip> recycleTip = recyclingTipService.getAllRecyclingTipsById(id);

        if (recycleTip.isPresent()) {
            return new ResponseEntity<>(recycleTip.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecycleTip(@Validated @RequestBody RecyclingTip recycleTip) {

        try {
            RecyclingTip createdRecycleTip = recyclingTipService.createRecyclingTip(recycleTip);
            return new ResponseEntity<>(createdRecycleTip, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id,
            @RequestBody RecyclingTip recyclingTip) {
        try {
            RecyclingTip updatedTip = recyclingTipService.updateRecyclingTip(recyclingTip, id);

            return new ResponseEntity<>(updatedTip, HttpStatus.OK);

        } catch (RuntimeException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        try {
            recyclingTipService.deleteRecyclingTip(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (RuntimeException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
