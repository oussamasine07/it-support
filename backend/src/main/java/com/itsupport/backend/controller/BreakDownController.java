package com.itsupport.backend.controller;

import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.service.BreakDownService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BreakDown")
@CrossOrigin
public class BreakDownController {

    private final BreakDownService serviceBreakDown;

    public BreakDownController(BreakDownService serviceBreakDown) {
        this.serviceBreakDown = serviceBreakDown;
    }

    // Ajouter une panne
    @PostMapping
    public ResponseEntity<BreakDown> createBreakdown(@RequestBody @Valid BreakdownDTO breakdownDTO) {
        BreakDown saved = serviceBreakDown.addBreakDown(breakdownDTO);
        return ResponseEntity.ok(saved);
    }

    // ✅ Lister toutes les pannes
    @GetMapping
    public ResponseEntity<List<BreakDown>> getAllBreakdowns() {
        return ResponseEntity.ok(serviceBreakDown.ListyAllBreakDown());
    }

    // ✅ Afficher une panne par ID
    @GetMapping("/{id}")
    public ResponseEntity<BreakDown> getBreakdownById(@PathVariable int id) {
        return serviceBreakDown.showBreakDown(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Modifier une panne
    @PutMapping("/{id}")
    public ResponseEntity<BreakDown> updateBreakdown(@PathVariable int id, @RequestBody @Valid BreakdownDTO breakdownDTO) {
        return serviceBreakDown.updateBreakDown(id, breakdownDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Supprimer une panne
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBreakdown(@PathVariable int id) {
        serviceBreakDown.deleteBreakDown(id);
        return ResponseEntity.noContent().build();
    }
}
