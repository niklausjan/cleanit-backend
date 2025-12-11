package ch.cleanit.backend.exception;

public class NoSuchCustomerFoundException extends RuntimeException {
    public NoSuchCustomerFoundException(String message) {
        super(message);
    }
}
