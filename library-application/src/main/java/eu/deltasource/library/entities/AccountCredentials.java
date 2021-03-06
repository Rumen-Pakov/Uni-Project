package eu.deltasource.library.entities;

import eu.deltasource.library.exceptions.IllegalInputException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Stores credentials for {@link UserAccountDetails}.
 */
@Getter
@Setter
@NoArgsConstructor
public class AccountCredentials {

    private String username;
    private String password;

    public AccountCredentials(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    private void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalInputException("Password for new account credentials can not be null");
        }
        this.password = password;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalInputException("Username for new account credentials can not be null");
        }
        this.username = username.trim();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AccountCredentials{" +
                "username='" + username + '\'' +
                '}';
    }
}
