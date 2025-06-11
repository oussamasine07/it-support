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
}
