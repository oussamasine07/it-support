package com.itsupport.backend.service;

import com.itsupport.backend.dto.TicketDTO;
import com.itsupport.backend.model.Ticket;
import com.itsupport.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    //create ticket
    public Ticket createTicket(TicketDTO ticketDTO){
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketDTO.description());
        ticket.setImage(ticketDTO.image());
        ticket.setStatus(ticketDTO.status());
        ticket.setBreakDown(ticketDTO.breakDown());
        ticket.setMaterial(ticketDTO.material());

        return ticketRepository.save(ticket);
    }


    //view all tickets
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
