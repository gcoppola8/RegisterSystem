package dev.coppola.RegisterSystem.console;

import dev.coppola.RegisterSystem.console.api.DeleteResponse;
import dev.coppola.RegisterSystem.console.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    List<User> getAllUsers() {
        List<User> result = userService.findAll();
        return result;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/user/{usernameToDelete}")
    DeleteResponse deleteUser(@PathVariable String usernameToDelete, HttpServletResponse httpResp) {
        DeleteResponse resp = new DeleteResponse();
        try {
            userService.deleteUserByUsername(usernameToDelete);
            resp.setMessage("User deleted with success!");
        } catch (Exception e) {
            resp.setMessage("Username or password error.");
            httpResp.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return resp;
    }
}
