package com.itsupport.backend.model;

import jakarta.persistence.*;


@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description ;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;


    @ManyToOne
    @JoinColumn(name = "breakdown_id")
    private BreakDown breakDown;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BreakDown getBreakDown() {
        return breakDown;
    }

    public void setBreakDown(BreakDown breakDown) {
        this.breakDown = breakDown;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
