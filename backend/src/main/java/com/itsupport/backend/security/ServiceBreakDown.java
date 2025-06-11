package com.itsupport.backend.security;

import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.repository.BreakDownRepo;
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

    public List<BreakDown> ListyAllBreakDown(){
        return breakDownRepo.findAll();
    }
    public Optional<BreakDown> showBreakDown(int id){
        return breakDownRepo.findById(id);
    }

}
