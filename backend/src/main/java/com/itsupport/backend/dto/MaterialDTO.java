package com.itsupport.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record MaterialDTO(
        Long id,
        @NotBlank(message = "name is required")
        String name,

        @NotBlank(message = "description is required")
        String description,

        @NotBlank(message = "type is required")
        String type

) {
}
