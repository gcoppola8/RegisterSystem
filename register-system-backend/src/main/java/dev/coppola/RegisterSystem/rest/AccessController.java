package dev.coppola.RegisterSystem.rest;

import dev.coppola.RegisterSystem.rest.api.LoginRequest;
import dev.coppola.RegisterSystem.rest.api.LoginResponse;
import dev.coppola.RegisterSystem.rest.api.RegisterRequest;
import dev.coppola.RegisterSystem.rest.api.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AccessController {

    @Autowired
    AccessService accessService;

    @PostMapping(value = "/register")
    RegisterResponse register(@Valid @RequestBody RegisterRequest req, HttpServletResponse httpResp) {
        RegisterResponse resp = new RegisterResponse();
        try {
            accessService.registerUser(req.getUsername(), req.getPassword());
            resp.setMessage("User registered.");
        } catch (Exception e) {
            httpResp.setStatus(HttpStatus.UNAUTHORIZED.value());
            resp.setMessage("Registration returned an error.");
        }
        return resp;
    }

    @PostMapping(value = "/login")
    LoginResponse login(@Valid @RequestBody LoginRequest req, HttpServletRequest httpReq, HttpServletResponse httpResp) {
        LoginResponse resp = new LoginResponse();
        try {
            resp.setMessage("Authentication successful.");
            String usernameAuthenticated = accessService.loginUser(req.getUsername(), req.getPassword());
            httpReq.getSession().setAttribute("userLogged", usernameAuthenticated);
            resp.setToken(httpReq.getSession().getId());
        } catch (Exception e) {
            resp.setMessage("Username or password error.");
            httpResp.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return resp;
    }
}
