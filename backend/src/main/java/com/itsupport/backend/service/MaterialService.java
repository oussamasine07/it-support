package com.itsupport.backend.service;

import com.itsupport.backend.dto.MaterialDTO;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.repository.MaterialRepository;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final UserRepository userRepository;

    public MaterialService(
            MaterialRepository materialRepository,
            UserRepository userRepository
    ) {
        this.materialRepository = materialRepository;
        this.userRepository = userRepository;
    }

    public List<Material> listAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(long id) {
        return materialRepository.findById(id);
    }

//    public Material createNewMaterial(MaterialDTO material, String token) {
//
//        //check if user is admin
//    }
}
