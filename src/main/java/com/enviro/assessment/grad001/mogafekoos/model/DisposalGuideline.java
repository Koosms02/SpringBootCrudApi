package com.enviro.assessment.grad001.mogafekoos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "guidelines are mandatory")
    @Size(min = 5, max = 500, message = "Instructions must be between 5 and 500 characters")
    private String guideline;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DisposalGuideline() {
    }

    public DisposalGuideline(Long id, String guideline, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.guideline = guideline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public String getGuideline() {
        return this.guideline;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}