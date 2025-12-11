package ch.cleanit.backend.exception;

public class NoSuchShopFoundException extends RuntimeException {
    public NoSuchShopFoundException(String message) {
        super(message);
    }
}
