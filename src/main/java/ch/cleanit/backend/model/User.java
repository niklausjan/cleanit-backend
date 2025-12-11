package ch.cleanit.backend.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Builder.Default
    private final UUID id = UUID.randomUUID();

    @NonNull
    @Builder.Default
    private final List<Role> roles = new ArrayList<>();

    private String firstName;

    private String lastName;

    private String mobile;

    private String mail;
}
