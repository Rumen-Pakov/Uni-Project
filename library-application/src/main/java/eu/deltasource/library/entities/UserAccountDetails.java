package eu.deltasource.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.deltasource.library.entities.enums.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Contains all personal information about user, such as name age sex location.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountDetails {

    private Name name;
    private int age;
    private Sex sex;
    private String email;
    private Location location;
    private AccountCredentials accountCredentials;

    UserAccountDetails(UserAccountDetailsBuilder builder) {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.sex = builder.getSex();
        this.email = builder.getEmail();
        this.location = builder.getLocation();
        this.accountCredentials = builder.getAccountCredentials();
    }

    private String getPassword() {
        return accountCredentials.getPassword();
    }

    public String getUserName() {
        return accountCredentials.getUsername();
    }

    @JsonIgnore
    public String getName() {
        return name.getName();
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Checks if given password matches the password of this user.
     *
     * @param password Given password
     * @return True if matches
     */
    public boolean isPasswordMatching(String password) {
        return getPassword().equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof UserAccountDetails) {
            UserAccountDetails that = (UserAccountDetails) o;
            return name.equals(that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
