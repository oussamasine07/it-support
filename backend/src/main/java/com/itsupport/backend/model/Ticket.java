package com.itsupport.backend.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description ;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "custom_breakdown", nullable = true)
    private String customBreakdown;

    public String getCustomBreakdown() {
        return customBreakdown;
    }

    public void setCustomBreakdown(String customBreakdown) {
        this.customBreakdown = customBreakdown;
    }

    @OneToOne
    @JoinColumn(name = "breakdown_id")
    private BreakDown breakDown;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @ManyToOne
    private User assignedToTechnician;

    @ManyToOne
    private User createdByEmployee;

    public User getAssignedToTechnician() {
        return assignedToTechnician;
    }

    public void setAssignedToTechnician(User assignedToTechnician) {
        this.assignedToTechnician = assignedToTechnician;
    }

    public User getCreatedByEmployee() {
        return createdByEmployee;
    }

    public void setCreatedByEmployee(User createdByEmployee) {
        this.createdByEmployee = createdByEmployee;
    }

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
