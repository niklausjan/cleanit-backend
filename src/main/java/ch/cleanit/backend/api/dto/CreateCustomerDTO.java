package ch.cleanit.backend.api.dto;

import java.util.UUID;

public record CreateCustomerDTO(
        String firstName, String lastName, String mail
) {}
