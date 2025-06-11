package com.itsupport.backend.dto;

import com.itsupport.backend.model.BreakDown;
import com.itsupport.backend.model.Material;
import com.itsupport.backend.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketDTO(
        @NotBlank(message = "Description is required")
        String description,
        @NotBlank(message = "Image is required")
        String image,
        @NotNull(message = "Status is required")
        Status status,
        @NotNull(message = "BreakDown is required")
        BreakDown breakDown,
        @NotNull(message = "Material is required")
        Material material
) {}
