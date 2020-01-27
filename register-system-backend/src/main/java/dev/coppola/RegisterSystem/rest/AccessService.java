package dev.coppola.RegisterSystem.rest;

import dev.coppola.RegisterSystem.console.api.User;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccessService {

    /* The library Jasypt contains a rich catalog of encryption algorithms,
     I keep the demo program simple using just the basic one.
     */
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    Logger logger = LoggerFactory.getLogger(AccessService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    void registerUser(String username, String password) throws Exception {
        String q = "INSERT INTO user(username, password) VALUES(?,?)";
        logger.debug("Encrypting password...");
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        logger.debug("Execute query on database.");
        jdbcTemplate.update(q, new Object[]{username, encryptedPassword});
    }

    String loginUser(String username, String password) throws Exception {
        String q = "SELECT id, username, password FROM user WHERE username = ?";

        logger.debug("Get user to authenticate from db.");
        User userToAuthenticate = jdbcTemplate.queryForObject(q, new Object[]{username},
                (resultSet, i) -> {
                    User u = new User();
                    u.setId(resultSet.getInt(1));
                    u.setUsername(resultSet.getString(2));
                    u.setPassword(resultSet.getString(3));
                    return u;
                });


        logger.debug("Verify credentials.");
        if (userToAuthenticate != null &&
                passwordEncryptor.checkPassword(password, userToAuthenticate.getPassword())) {
            logger.debug("User " + userToAuthenticate.getUsername() + " is authenticated with success.");
            return userToAuthenticate.getUsername();
        } else {
            logger.debug("Authentication error.");
            throw new Exception("Authentication error");
        }
    }
}
