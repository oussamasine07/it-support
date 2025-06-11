package com.itsupport.backend.controller;

import com.itsupport.backend.model.Ticket;
import com.itsupport.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/tickets")

public class TicketController {
    private final TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @PreAuthorize("hasAuthority('TECHNICIAN')")
    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }


}
