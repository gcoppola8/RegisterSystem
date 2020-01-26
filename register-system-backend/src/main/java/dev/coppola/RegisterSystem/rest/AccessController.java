package dev.coppola.RegisterSystem.rest;

import dev.coppola.RegisterSystem.rest.api.LoginRequest;
import dev.coppola.RegisterSystem.rest.api.LoginResponse;
import dev.coppola.RegisterSystem.rest.api.RegisterRequest;
import dev.coppola.RegisterSystem.rest.api.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccessController {

    @Autowired
    AccessService accessService;

    @PostMapping(value = "/register")
    RegisterResponse register(@Valid @RequestBody RegisterRequest req) {
        RegisterResponse resp = new RegisterResponse();
        accessService.registerUser(req.getUsername(), req.getPassword());
        return resp;
    }

    @PostMapping(value = "/login")
    LoginResponse login(@Valid @RequestBody LoginRequest req) {
        LoginResponse resp = new LoginResponse();
        accessService.loginUser(req.getUsername(), req.getPassword());
        return resp;
    }
}
