package com.itsupport.backend.service;

import com.itsupport.backend.dto.TicketDTO;
import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.model.Ticket;
import com.itsupport.backend.repository.BreakDownRepository;
import com.itsupport.backend.repository.MaterialRepository;
import com.itsupport.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final BreakDownRepository breakDownRepository;
    private final MaterialRepository materialRepository;


    public TicketService(
            final TicketRepository ticketRepository,
            final BreakDownRepository breakDownRepository,
            final MaterialRepository materialRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.breakDownRepository = breakDownRepository;
        this.materialRepository = materialRepository;
    }

    //create ticket
    public Ticket createTicket(TicketDTO ticketDTO){
        // check datatype of breakdown id
        Long breakdownId = (ticketDTO.breakdown_id() != null && !ticketDTO.breakdown_id().isEmpty())
                ? Long.parseLong(ticketDTO.breakdown_id())
                : 0L;

        BreakDown breakDown = breakdownId > 0
                ? breakDownRepository.findById(Math.toIntExact(breakdownId)).orElseThrow()
                : null;

        Material material = materialRepository.findById(ticketDTO.material_id()).orElseThrow();

        // todo get auth user and add it to created by

        Ticket ticket = new Ticket();
        ticket.setDescription(ticketDTO.description());
        ticket.setImage(ticketDTO.image());
        ticket.setStatus(ticketDTO.status());
        ticket.setBreakDown(breakDown);
        ticket.setMaterial(material);

        return ticketRepository.save(ticket);
    }


    //view all tickets
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
