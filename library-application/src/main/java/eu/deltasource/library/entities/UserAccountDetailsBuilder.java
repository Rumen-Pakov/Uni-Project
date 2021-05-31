package eu.deltasource.library.entities;

import eu.deltasource.library.entities.enums.Sex;
import eu.deltasource.library.exceptions.*;
import lombok.Getter;

/**
 * This static class is used for building {@link UserAccountDetails} object
 */
@Getter
public class UserAccountDetailsBuilder {

    private int age;
    private Name name;
    private Sex sex;
    private String email;
    private Location location;
    private AccountCredentials accountCredentials;

    private UserAccountDetailsBuilder() {}

    public static UserAccountDetailsBuilder builder() {
        return new UserAccountDetailsBuilder();
    }

    public UserAccountDetailsBuilder name(Name name) {
        if (isNull(name)) {
            throw new IllegalUserAccountDetailsNameException("Name can not be null");
        }
        this.name = name;
        return this;
    }

    public UserAccountDetailsBuilder age(int age) {
        if (age <= 0) {
            throw new IllegalAgeException("Age can not be less than or equal to 0");
        }
        this.age = age;
        return this;
    }

    public UserAccountDetailsBuilder sex(Sex sex) {
        if (isNull(sex)) {
            throw new IllegalSexException("Sex can not be null");
        }
        this.sex = sex;
        return this;
    }

    public UserAccountDetailsBuilder email(String email) {
        if (isNull(email) || isEmptyString(email)) {
            throw new IllegalAddressException("Address can not be null or empty");
        }
        this.email = email;
        return this;
    }

    public UserAccountDetailsBuilder location(Location location) {
        if (isNull(location)) {
            throw new IllegalLocationException("Location can not be null");
        }
        this.location = location;
        return this;
    }

    public UserAccountDetailsBuilder accountCredentials(AccountCredentials accountCredentials) {
        if (isNull(accountCredentials)) {
            throw new IllegalAccountCredentialsException("Account credentials can not be null");
        }
        this.accountCredentials = accountCredentials;
        return this;
    }

    public UserAccountDetails build() {
        return new UserAccountDetails(this);
    }

    private boolean isNull(Object obj) {
        return obj == null;
    }

    private boolean isEmptyString(String str) {
        return str.trim().isEmpty();
    }
}
