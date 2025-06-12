package com.itsupport.backend.security;

import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBreakDown {

    private final BreakDownRepo breakDownRepo;


    public ServiceBreakDown(
        final BreakDownRepo breakDownRepo
    ){
      this.breakDownRepo = breakDownRepo;
    }

    //lister toutes les pannes

    public List<BreakDown> ListyAllBreakDown(){
        return breakDownRepo.findAll();
    }

    //aficher une SpannerDialect par ID

    public Optional<BreakDown> showBreakDown(int id){
        return breakDownRepo.findById(id);
    }

    //to do :add token
    // ajouter une panne

    public BreakDown addBreakDown(BreakdownDTO breakdownDTO) {
        BreakDown breakDown = new BreakDown();
        breakDown.setName(breakdownDTO.name());
        return breakDownRepo.save(breakDown);

    }
    //Mettre a jour une panne
    public Optional<BreakDown> updateBreakDown(int id, BreakdownDTO breakdownDTO) {
        return breakDownRepo.findById(id).map(existing -> {
            existing.setName(breakdownDTO.name());
            return breakDownRepo.save(existing);
        });
    }
    //supprimer une panne
    public void deleteBreakDown(int id) {
        breakDownRepo.deleteById(id);
    }



}




