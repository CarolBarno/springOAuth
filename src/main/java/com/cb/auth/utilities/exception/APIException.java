/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.exception;

import java.text.MessageFormat;
import org.springframework.http.HttpStatus;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class APIException extends RuntimeException {

    private final ApiError apiError;

    public APIException(final ApiError apiError) {
        super(apiError.getMessage());
        this.apiError = apiError;
    }

    public static APIException badRequest(final String message, final Object... args) {
        return new APIException(
                new ApiError(HttpStatus.BAD_REQUEST, MessageFormat.format(message, args))
        );
    }

    public static APIException notFound(final String message, final Object... args) {
        return new APIException(
                new ApiError(HttpStatus.NOT_FOUND, MessageFormat.format(message, args))
        );
    }

    public static APIException conflict(final String message, final Object... args) {
        return new APIException(
                new ApiError(HttpStatus.CONFLICT, MessageFormat.format(message, args))
        );
    }

    public static APIException internalError(final String message, final Object... args) {

        return new APIException(
                new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, MessageFormat.format(message, args))
        );
    }

    public ApiError apiError() {
        return this.apiError;
    }

    @Override
    public String toString() {
        return "APIException{"
                + "apiError=" + apiError
                + '}';
    }
}
