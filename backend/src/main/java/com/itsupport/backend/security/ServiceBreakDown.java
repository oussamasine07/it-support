package com.itsupport.backend.security;

import com.itsupport.backend.dto.BreakdownDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.repository.BreakDownRepo;
import org.hibernate.dialect.SpannerDialect;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public BreakDown addBreakDown(BreakdownDTO breakdownDTO){
        BreakDown breakDown = new BreakDown();
        breakDown.setName(breakdownDTO.name());
        return breakDownRepo.save(breakDown);

        //Mettre a jour une panne
    }



}
