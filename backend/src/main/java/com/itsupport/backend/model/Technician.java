package com.itsupport.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "technicians")
public class Technician extends User {

    @Column(name = "specialty", nullable = false)
    private String Specialty;

    public Technician () {}

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }
}
