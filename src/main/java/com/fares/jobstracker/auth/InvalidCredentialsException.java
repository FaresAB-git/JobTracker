package com.fares.jobstracker.auth;

import com.fares.jobstracker.common.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidCredentialsException extends UnauthorizedException {
    public InvalidCredentialsException() {
        super("E-mail ou mot de passe incorrect");
    }
}