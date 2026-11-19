package com.fares.jobstracker.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(
        @Email @Size(max = 255)
        String email,

        @Size(max = 100) @Pattern(regexp = ".*\\S.*", message = "ne doit pas être vide")
        String firstName,

        @Size(max = 100) @Pattern(regexp = ".*\\S.*", message = "ne doit pas être vide")
        String lastName
) {}