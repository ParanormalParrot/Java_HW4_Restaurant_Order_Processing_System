package com.example.hw4.authentification;

import lombok.*;
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse extends Response {
    private String token;
}
