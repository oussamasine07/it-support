package com.itsupport.backend.service;

import com.itsupport.backend.repository.MaterialRepository;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

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

}
