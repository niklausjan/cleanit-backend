package ch.cleanit.backend.api.dto;

import java.util.UUID;

public record CreateOrderDTO(
        UUID customerId, UUID shopId
) {}
