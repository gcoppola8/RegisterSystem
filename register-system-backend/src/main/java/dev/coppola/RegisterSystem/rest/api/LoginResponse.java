package dev.coppola.RegisterSystem.rest.api;

import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private String token;
    private String lastLogin;
}
