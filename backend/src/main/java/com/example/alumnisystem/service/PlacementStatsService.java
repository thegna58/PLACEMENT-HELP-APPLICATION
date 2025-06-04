// PlacementStatsService.java
package com.example.alumnisystem.service;

import com.example.alumnisystem.dto.PlacementStatsDTO;
import com.example.alumnisystem.model.PlacementStats;
import com.example.alumnisystem.repository.PlacementStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlacementStatsService {

    @Autowired
    private PlacementStatsRepository repository;

    public List<PlacementStatsDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PlacementStatsDTO save(PlacementStatsDTO dto) {
        PlacementStats entity = convertToEntity(dto);
        PlacementStats saved = repository.save(entity);
        return convertToDTO(saved);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Entity -> DTO
    private PlacementStatsDTO convertToDTO(PlacementStats entity) {
        PlacementStatsDTO dto = new PlacementStatsDTO();
        dto.setId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setCompanyName(entity.getCompanyName());
        dto.setYear(entity.getYear());
        dto.setStudentsPlaced(entity.getStudentsPlaced());
        dto.setAveragePackage(entity.getAveragePackage());
        return dto;
    }

    // DTO -> Entity
    private PlacementStats convertToEntity(PlacementStatsDTO dto) {
        PlacementStats entity = new PlacementStats();
        entity.setId(dto.getId());
        entity.setRole(dto.getRole());
        entity.setCompanyName(dto.getCompanyName());
        entity.setYear(dto.getYear());
        entity.setStudentsPlaced(dto.getStudentsPlaced());
        entity.setAveragePackage(dto.getAveragePackage());
        return entity;
    }
}
