package com.itsupport.backend.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
@Table(name = "Breakdowns")


public class BreakDown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", nullable = false)
    private String name;

    @OneToOne(mappedBy = "breakDown")
    private Ticket ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
