
package com.itsupport.backend.controller;


import com.itsupport.backend.dto.MaterialDTO;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Materials")
@CrossOrigin
public class MaterialController {

    private final MaterialService materialService;
    public MaterialController(
            final MaterialService materialService
    ){
        this.materialService = materialService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Material> getAllMaterials(){
        return materialService.listAllMaterials();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Material> showMaterial(@PathVariable long id){
        return materialService.getMaterialById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Material createMaterial(@Valid @RequestBody MaterialDTO material, @RequestHeader("authorization") String token){
        return materialService.createNewMaterial(material, token);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Material  updateMaterial(@PathVariable long id, @RequestBody MaterialDTO material, @RequestHeader("authorization") String token){
        return materialService.updateMaterial(id, material, token);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMaterial(@PathVariable long id, @RequestHeader("authorization") String token){
        materialService.deleteMaterial(id, token);
    }

}
