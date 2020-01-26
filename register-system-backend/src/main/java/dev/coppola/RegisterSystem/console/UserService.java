package dev.coppola.RegisterSystem.console;

import dev.coppola.RegisterSystem.console.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<User> findAll() {
        String q = "SELECT id, username, registered_on FROM user";

        List<User> result = jdbcTemplate.query(q, (resultSet, i) -> {
            User u = new User();
            u.setId(resultSet.getInt(1));
            u.setUsername(resultSet.getString(2));
            u.setRegisteredOn(resultSet.getString(3));
            return u;
        });

        return result;
    }

    void deleteUserByUsername(String username) {
        String q = "DELETE FROM user WHERE username = ?";
        jdbcTemplate.update(q, new Object[]{username});
    }
}
