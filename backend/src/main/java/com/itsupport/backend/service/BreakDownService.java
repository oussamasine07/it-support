package com.itsupport.backend.service;
import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.model.User;
import com.itsupport.backend.repository.BreakDownRepository;
import com.itsupport.backend.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBreakDown {

    private final BreakDownRepository breakDownRepository;
    private final UserRepository userRepository;

    public ServiceBreakDown(BreakDownRepository breakDownRepository, UserRepository userRepository) {
        this.breakDownRepository = breakDownRepository;
        this.userRepository = userRepository;
    }

    // ✅ Ajouter une panne
    public BreakDown addBreakDown(BreakdownDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Récupère le nom d'utilisateur du token

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        BreakDown breakDown = new BreakDown();
        breakDown.setTitle(dto.getTitle());
        breakDown.setDescription(dto.getDescription());
        breakDown.setStatus(dto.getStatus());
        breakDown.setCreatedAt(dto.getCreatedAt());
        breakDown.setUser(user); // lie la panne à l'utilisateur connecté

        return breakDownRepository.save(breakDown);
    }

}

