package com.fares.jobstracker.common.exception;

import org.springframework.http.HttpStatus;

public abstract class UnauthorizedException extends ApiException {
    protected UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}