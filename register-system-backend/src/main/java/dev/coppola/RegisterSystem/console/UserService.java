package dev.coppola.RegisterSystem.console;

import dev.coppola.RegisterSystem.console.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<User> findAll() {
        String q = "SELECT id, username, registered_on FROM user";

        logger.debug("Fetching all the user from the database.");
        List<User> result = jdbcTemplate.query(q, (resultSet, i) -> {
            User u = new User();
            u.setId(resultSet.getInt(1));
            u.setUsername(resultSet.getString(2));
            u.setRegisteredOn(resultSet.getString(3));
            return u;
        });

        return result;
    }

    void deleteUserByUsername(String username) throws Exception {
        String q = "DELETE FROM user WHERE username = ?";

        logger.debug("Executing the deleteUser query on the database.");
        int code = jdbcTemplate.update(q, new Object[]{username});
        if (code == 0) { // No rows affected => then the user didn't exist
            logger.debug("User " + username + " doesn't exist.");
            throw new Exception("Username not valid.");
        }
    }
}
