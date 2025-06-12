package com.itsupport.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record BreakdownDTO(


        @NotBlank(message = "Le nom est requis")
        String name

) {
}
