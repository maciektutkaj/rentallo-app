package com.sda.rentalloapp.exception;

public class WrongClientException extends RuntimeException{
    public WrongClientException() {
    }

    public WrongClientException(String message) {
        super(message);
    }

    public WrongClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongClientException(Throwable cause) {
        super(cause);
    }

    public WrongClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
