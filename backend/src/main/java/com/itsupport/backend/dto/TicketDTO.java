package com.itsupport.backend.dto;

import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketDTO(
        @NotBlank(message = "Description is required")
        String description,

        String image,

        @NotNull(message = "Status is required")
        Status status,
        @NotNull(message = "BreakDown is required")
        String breakdown_id,
        @NotNull(message = "Material is required")
        Long material_id



) {}
