package com.itsupport.backend.service;

import com.itsupport.backend.dto.AuthUserDTO;
import com.itsupport.backend.dto.LoginDTO;
import com.itsupport.backend.dto.RegisterDTO;
import com.itsupport.backend.exception.PasswordIncorrectException;
import com.itsupport.backend.mapper.UserMapper;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.remote.JMXAuthenticator;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public UserService (
            final UserRepository userRepository,
            final AuthenticationManager authenticationManager,
            final UserMapper userMapper,
            final JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
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

    public ResponseEntity<?> verify ( User user) {
        try {

            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    user.getEmail(),
                                    user.getPassword()
                            )
                    );

            if (authentication.isAuthenticated()){
                AuthUserDTO authUser = this.getAuthenticatedUser(user.getEmail());
                String token = jwtService.generateJwtToken(authUser);

                Map<String, String> responseSuccess = new HashMap<>();
                responseSuccess.put("token", token);

                return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
            }

            throw  new PasswordIncorrectException("Invalid credentials");
        }
        catch (AuthenticationException e ) {
            throw  new PasswordIncorrectException("Invalid credentials");
        }
    }

    public AuthUserDTO getAuthenticatedUser ( String email ) {
        User authenticatedUser = userRepository.findUserByEmail( email );
        return userMapper.toDTO(authenticatedUser);
    }

}
