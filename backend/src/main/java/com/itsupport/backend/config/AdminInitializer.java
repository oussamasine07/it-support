package com.itsupport.backend.config;

import com.itsupport.backend.model.Role;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {
    @Bean
    CommandLineRunner createAdmin (UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if  (userRepository.findUserByEmail("sine@gmail.com") == null) {
                User newUser = new User();

                newUser.setFullName("oussama");
                newUser.setEmail("sine@gmail.com");
                newUser.setPassword(encoder.encode("123456"));
                newUser.setRole(Role.ADMIN);

                userRepository.save(newUser);

            } else {
                System.out.println("this user is already exists");
            }
        };
    }
}
