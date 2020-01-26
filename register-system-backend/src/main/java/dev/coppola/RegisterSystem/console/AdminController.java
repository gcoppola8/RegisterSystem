package dev.coppola.RegisterSystem.console;

import dev.coppola.RegisterSystem.console.api.DeleteResponse;
import dev.coppola.RegisterSystem.console.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        List<User> result = userService.findAll();
        return result;
    }

    @DeleteMapping("/user/{usernameToDelete}")
    DeleteResponse deleteUser(@PathVariable String usernameToDelete) {
        DeleteResponse resp = new DeleteResponse();
        userService.deleteUserByUsername(usernameToDelete);
        resp.setMessage("User deleted with success!");
        return resp;
    }
}
