package com.itsupport.backend.controller;


import com.itsupport.backend.model.Material;
import com.itsupport.backend.service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
