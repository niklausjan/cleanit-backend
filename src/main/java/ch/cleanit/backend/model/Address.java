package ch.cleanit.backend.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NonNull
    private String street;

    @NonNull
    private String plz;

    @NonNull
    private String city;
}
