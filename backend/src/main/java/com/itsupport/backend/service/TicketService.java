package com.itsupport.backend.service;

import com.itsupport.backend.model.Ticket;
import com.itsupport.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    //create ticket
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
