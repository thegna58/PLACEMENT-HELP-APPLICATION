// PlacementStatsController.java
package com.example.alumnisystem.controller.placement;

import com.example.alumnisystem.dto.PlacementStatsDTO;
import com.example.alumnisystem.service.PlacementStatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
@CrossOrigin(origins = "*")
public class PlacementStatsController {

    private final PlacementStatsService service;

    public PlacementStatsController(PlacementStatsService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlacementStatsDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public PlacementStatsDTO add(@RequestBody PlacementStatsDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
