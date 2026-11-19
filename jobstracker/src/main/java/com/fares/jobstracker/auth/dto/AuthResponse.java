package com.fares.jobstracker.auth.dto;

import com.fares.jobstracker.user.dto.UserResponse;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresIn,
        UserResponse user
) {}