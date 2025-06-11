package com.itsupport.backend.dto;

import com.itsupport.backend.model.Role;
import com.itsupport.backend.validation.UniqueEmail;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank(message = "full name is required")
        String fullName,

        @NotBlank(message = "email is required")
        @Email(message = "please enter a valid email")
        @UniqueEmail
        String email,

        @NotBlank(message = "password is required")
        @Min(value = 6, message = "password must be at least 6 chars")
        String password,

        @NotNull(message = "role is required")
        Role role
) {
}
