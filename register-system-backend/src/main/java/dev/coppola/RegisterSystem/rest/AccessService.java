package dev.coppola.RegisterSystem.rest;

import dev.coppola.RegisterSystem.console.api.User;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccessService {

    /* The library Jasypt contains a rich catalog of encryption algorithms,
     I keep the demo program simple using just the basic one.
     */
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    void registerUser(String username, String password) {
        String q = "INSERT INTO user(username, password) VALUES(?,?)";
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        jdbcTemplate.update(q, new Object[]{username, encryptedPassword});
    }

    String loginUser(String username, String password) {
        String q = "SELECT id, username, password FROM user WHERE username = ?";

        User userToAuthenticate = jdbcTemplate.queryForObject(q, new Object[]{username},
                (resultSet, i) -> {
                    User u = new User();
                    u.setId(resultSet.getInt(1));
                    u.setUsername(resultSet.getString(2));
                    u.setPassword(resultSet.getString(3));
                    return u;
                });

        boolean authenticated = passwordEncryptor.checkPassword(password, userToAuthenticate.getPassword());
        if(authenticated){
            //TODO : return the token
        }
        return userToAuthenticate.getUsername();
    }
}
