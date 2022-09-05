package dev.simon.contactmanagerapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
