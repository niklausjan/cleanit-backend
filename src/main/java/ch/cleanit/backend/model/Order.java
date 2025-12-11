package ch.cleanit.backend.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Builder.Default
    private final UUID id = UUID.randomUUID();

    @NonNull
    @Builder.Default
    private OrderState orderState = OrderState.RECEIVED;

    @NonNull
    private User customer;

    @NonNull
    private Shop shop;

    @NonNull
    private final LocalDateTime created = LocalDateTime.now();

    private LocalDateTime washed;

    private LocalDateTime finished;
}
