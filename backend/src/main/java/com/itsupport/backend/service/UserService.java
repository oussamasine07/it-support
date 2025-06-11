package com.itsupport.backend.service;

import com.itsupport.backend.dto.RegisterDTO;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (
            final UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User registerUser ( RegisterDTO registerDTO ) {
        User newUser = new User();

        String encryptedPassword = encoder.encode( registerDTO.password() );

        newUser.setFullName(registerDTO.fullName());
        newUser.setEmail(registerDTO.email());
        newUser.setPassword( encryptedPassword );
        newUser.setRole( registerDTO.role() );

        return userRepository.save(newUser);
    }

}
