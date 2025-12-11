package ch.cleanit.backend.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shop {
    @Builder.Default
    private final UUID id = UUID.randomUUID();

    @NonNull
    private String name;

    @NonNull
    @Builder.Default
    private final List<User> managers = new ArrayList<>();

    @NonNull
    private Address location;

    @NonNull
    private final List<User> employees = new ArrayList<>();
}
