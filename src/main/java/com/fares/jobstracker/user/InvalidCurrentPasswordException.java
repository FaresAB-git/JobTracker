package com.fares.jobstracker.user;

import com.fares.jobstracker.common.exception.BadRequestException;

public class InvalidCurrentPasswordException extends BadRequestException {
    public InvalidCurrentPasswordException() {
        super("Le mot de passe actuel est incorrect");
    }
}