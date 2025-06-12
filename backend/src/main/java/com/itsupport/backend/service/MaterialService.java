package com.itsupport.backend.service;

import com.itsupport.backend.dto.MaterialDTO;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.model.Role;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.MaterialRepository;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

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

        String userNameFromToken = jwtService.extarctUsername(token.substring(7));

        //get user

          User user = userRepository.getUserByUsernameOrEmail(userNameFromToken);

  //check if user is admin
        if (user.getRole() == Role.ADMIN) {
            Material newMaterial = new Material();

            newMaterial.setName(material.name());
            newMaterial.setDescription(material.description());
            newMaterial.setImage(material.imageUrl());

            return materialRepository.save(newMaterial);
        }else{
            System.out.println("unauthoriezed action");
            throw new Error("unauthoriezed action");
        }
   }

   public Material updateMaterial(long id, MaterialDTO material, String token) {

        String userNameFromToken = jwtService.extarctUsername(token.substring(7));

        User user = userRepository.getUserByUsernameOrEmail(userNameFromToken);

       if (user.getRole() == Role.ADMIN) {
           Material newMaterial = materialRepository.findById(id).orElseThrow();

           newMaterial.setName(material.name());
           newMaterial.setDescription(material.description());
           newMaterial.setImage(material.imageUrl());

           return materialRepository.save(newMaterial);
       }else{
           System.out.println("unauthoriezed action");
           throw new Error("unauthoriezed action");
       }
   }

   public void deleteMaterial(long id, String token) {
        //get signin user
        String userNameFromToken = jwtService.extarctUsername(token.substring(7));

        //get user
       User user = userRepository.getUserByUsernameOrEmail(userNameFromToken);

       if (user.getRole() == Role.ADMIN) {
           materialRepository.deleteById(id);
       }else {
           System.out.println("unauthoriezed action");
           throw new Error("unauthoriezed action");
       }

   }
}
