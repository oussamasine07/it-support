
package com.itsupport.backend.service;

import com.itsupport.backend.dto.MaterialDTO;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.model.Role;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.MaterialRepository;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public MaterialService(
            MaterialRepository materialRepository,
            UserRepository userRepository,
            JwtService jwtService
    ) {
        this.materialRepository = materialRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public List<Material> listAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(long id) {
        return materialRepository.findById(id);
    }

    public Material createNewMaterial(MaterialDTO material, String token) {



        Material newMaterial = new Material();

        newMaterial.setName(material.name());
        newMaterial.setDescription(material.description());
        newMaterial.setImage(material.imageUrl());

        return materialRepository.save(newMaterial);

   }

   public Material updateMaterial(long id, MaterialDTO material, String token) {



       Material updatedMaterial = materialRepository.findById(id).orElseThrow();

       updatedMaterial.setName(material.name());
       updatedMaterial.setDescription(material.description());
       updatedMaterial.setImage(material.imageUrl());

       return materialRepository.save(updatedMaterial);

   }

   public void deleteMaterial(long id, String token) {

        materialRepository.deleteById(id);

   }

}