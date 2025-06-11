package com.itsupport.backend.dto;

import com.itsupport.backend.model.Role;
import com.itsupport.backend.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthUserDTO (
        Long id,
        String fullName,
        String email,
        Role role
) {
}
