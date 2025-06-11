package com.itsupport.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record BreakdownDTO(
        int id,

        @NotBlank(message = "name is required")
        String name

) {
}
