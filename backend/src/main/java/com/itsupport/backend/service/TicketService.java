package com.itsupport.backend.service;

import com.itsupport.backend.dto.TicketDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.model.Ticket;
import com.itsupport.backend.repository.BreakDownRepository;
import com.itsupport.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    //private final BreakDownRepository breakDownRepository;


    public TicketService(
            TicketRepository ticketRepository
            //BreakDownRepository breakDownRepository
    ) {
        this.ticketRepository = ticketRepository;
        //this.breakDownRepository = breakDownRepository;
    }

    //create ticket
    public Ticket createTicket(TicketDTO ticketDTO){
        // check datatype of breakdown id
        Long breakdown = (ticketDTO.breakDown() != null && !ticketDTO.breakDown().isEmpty())
                ? Long.parseLong(ticketDTO.breakDown())
                : 0L;
        BreakDown breakDown = breakdown != 0L ?

        Ticket ticket = new Ticket();
        ticket.setDescription(ticketDTO.description());
        ticket.setImage(ticketDTO.image());
        ticket.setStatus(ticketDTO.status());
        //ticket.setBreakDown(ticketDTO.breakDown());
        //ticket.setMaterial(ticketDTO.material());

        return ticketRepository.save(ticket);
    }


    //view all tickets
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
