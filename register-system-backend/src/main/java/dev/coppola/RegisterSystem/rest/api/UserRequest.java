package dev.coppola.RegisterSystem.rest.api;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserRequest {
    @Size(max = 255)
    protected String username;

    @Size(min = 8, max = 255)
    protected String password;

}
