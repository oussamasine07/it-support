package com.itsupport.backend.controller;

import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.security.ServiceBreakDown;
import com.itsupport.backend.service.BreakDownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BreakDown")
@CrossOrigin
public class BreakDownController {

    private final BreakDownService breakDownService;
    private final ServiceBreakDown serviceBreakDown;

    public BreakDownController(BreakDownService breakDownService, ServiceBreakDown serviceBreakDown) {
        this.breakDownService = breakDownService;
        this.serviceBreakDown = serviceBreakDown;
    }

    //ajouter une panne
    @PostMapping
    public ResponseEntity<BreakDown> addBreakDown(@RequestBody BreakdownDTO breakdownDTO) {
        BreakDown created = serviceBreakDown.addBreakDown(breakdownDTO);
        return ResponseEntity.ok(created);
    }
    //Lister touter touter les pannes
    @GetMapping("/{id}")
    public ResponseEntity<List<BreakDown>> getBreakDownById(@PathVariable("id") String id) {
        return ResponseEntity.ok(serviceBreakDown.ListyAllBreakDown());
    }

}
