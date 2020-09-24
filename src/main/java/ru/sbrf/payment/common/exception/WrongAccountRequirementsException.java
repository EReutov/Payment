package ru.sbrf.payment.common.exception;

public class WrongAccountRequirementsException extends RuntimeException {

    public WrongAccountRequirementsException(String message) {
        super(message);
    }

}
