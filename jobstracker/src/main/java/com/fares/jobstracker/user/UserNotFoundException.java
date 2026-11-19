package com.fares.jobstracker.user;

import com.fares.jobstracker.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("Utilisateur introuvable");
    }
}