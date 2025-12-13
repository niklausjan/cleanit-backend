package ch.cleanit.backend.service;

public class ValidationHelper {

    static void requireNonEmpty(String value, String name) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(name + " must not be null or empty");
        }
    }
}
