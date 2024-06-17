package com.enviro.assessment.grad001.mogafekoos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class WasteCategory {

    // us the Id and Generated value annotation to allow to automatic Id increment

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 5, max = 40, message = "Description must be less than 500 characters")
    private String category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WasteCategory() {
    }

    public WasteCategory(Long id, String category, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    // getter
    public Long getId() {
        return this.id;
    }

    public String getCategory() {
        return this.category;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}