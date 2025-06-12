package com.itsupport.backend.service;
import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.repository.BreakDownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreakDownService {

    private final BreakDownRepository breakDownRepository;

    public BreakDownService(BreakDownRepository breakDownRepository) {
        this.breakDownRepository = breakDownRepository;
    }

    // Ajouter une panne
    public BreakDown addBreakDown(BreakdownDTO dto) {
        BreakDown breakDown = new BreakDown();
        breakDown.setName(dto.name());
        return breakDownRepository.save(breakDown);
    }

    // Lister toutes les pannes
    public List<BreakDown> ListyAllBreakDown() {
        return breakDownRepository.findAll();
    }

    //  Afficher une panne par ID
    public Optional<BreakDown> showBreakDown(int id) {
        return breakDownRepository.findById(id);
    }

    //  Modifier une panne
    public Optional<BreakDown> updateBreakDown(int id, BreakdownDTO dto) {
        return breakDownRepository.findById(id).map(breakDown -> {
            breakDown.setName(dto.name());
            return breakDownRepository.save(breakDown);
        });
    }

    // Supprimer une panne
    public void deleteBreakDown(int id) {
        breakDownRepository.deleteById(id);
    }
}
