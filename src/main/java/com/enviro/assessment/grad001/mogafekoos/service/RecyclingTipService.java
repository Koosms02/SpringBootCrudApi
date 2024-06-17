package com.enviro.assessment.grad001.mogafekoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.mogafekoos.model.RecyclingTip;
import com.enviro.assessment.grad001.mogafekoos.repository.RecyclingTipRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    public Optional<RecyclingTip> getAllRecyclingTipsById(Long id) {
        return recyclingTipRepository.findById(id);
    }

    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {

        recyclingTip.setCreatedAt(LocalDateTime.now());
        recyclingTip.setUpdatedAt(LocalDateTime.now());

        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(RecyclingTip recyclingTipDetail, Long id) {

        RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RecycleTip is not found"));

        recyclingTip.setDescription(recyclingTipDetail.getDescription());
        recyclingTip.setUpdatedAt(LocalDateTime.now());

        return recyclingTipRepository.save(recyclingTip);

    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}