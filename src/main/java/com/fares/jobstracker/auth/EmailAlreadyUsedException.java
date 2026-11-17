package com.fares.jobstracker.auth;

import com.fares.jobstracker.common.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyUsedException extends ConflictException {
    public EmailAlreadyUsedException(String email) {
        super("Un compte existe déjà avec l'e-mail " + email);
    }
}