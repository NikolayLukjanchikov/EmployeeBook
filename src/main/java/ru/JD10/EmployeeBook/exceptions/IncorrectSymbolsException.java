package ru.JD10.EmployeeBook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectSymbolsException extends RuntimeException {
    public IncorrectSymbolsException() {
    }

    public IncorrectSymbolsException(String message) {
        super(message);
    }

    public IncorrectSymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectSymbolsException(Throwable cause) {
        super(cause);
    }

    public IncorrectSymbolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
