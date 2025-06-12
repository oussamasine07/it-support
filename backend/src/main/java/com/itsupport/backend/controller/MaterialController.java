package com.itsupport.backend.controller;


import com.itsupport.backend.dto.MaterialDTO;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Materials")
public class MaterialController {

    private final MaterialService materialService;
    public MaterialController(
            final MaterialService materialService
    ){
        this.materialService = materialService;
    }

    @GetMapping
    public List<Material> getAllMaterials(){
        return materialService.listAllMaterials();
    }

    @GetMapping("/{id}")
    public Optional<Material> showMaterial(@PathVariable long id){
        return materialService.getMaterialById(id);
    }

    @PostMapping
    public Material createMaterial(@Valid @RequestBody MaterialDTO material, @RequestHeader("authorization") String token){
        return materialService.createNewMaterial(material, token);
    }

    @PutMapping("/{id}")
    public Material  updateMaterial(@PathVariable long id, @RequestBody MaterialDTO material, @RequestHeader("authorization") String token){
        return materialService.updateMaterial(id, material, token);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable long id, @RequestHeader("authorization") String token){
        materialService.deleteMaterial(id, token);
    }







}
