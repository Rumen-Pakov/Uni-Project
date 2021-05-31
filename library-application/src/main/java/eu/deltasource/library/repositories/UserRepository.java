package eu.deltasource.library.repositories;

import eu.deltasource.library.entities.UserAccount;
import eu.deltasource.library.exceptions.AccountNotFoundException;
import eu.deltasource.library.exceptions.UserNameNotAvailableException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Contains all registered users, and the methods required to search for users and add
 * users to the repository.
 */
@Repository
public class UserRepository {

    private final Set<UserAccount> userAccounts = new HashSet<>();

    /**
     * Adds new user account to the repository.
     *
     * @param userAccount User account to add
     */
    public void addNewUserAccount(UserAccount userAccount) {
        if (isUserNameTaken(userAccount.getUserName())) {
            throw new UserNameNotAvailableException("Username is already taken. Value passed: " + userAccount.getUserName());
        }
        userAccounts.add(userAccount);
    }

    /**
     * Checks if given username is taken.
     *
     * @param userName Username to check
     * @return True if taken
     */
    private boolean isUserNameTaken(String userName) {
        return findAccountByUsername(userName)
                .isPresent();
    }

    /**
     * Searches for account by given username.
     *
     * @param userName Username to search by
     * @return User account found
     */
    public Optional<UserAccount> findAccountByUsername(String userName) {
        return userAccounts.stream()
                .filter(userAccount -> userAccount.getUserName().equalsIgnoreCase(userName))
                .findFirst();
    }

    /**
     * Removes user account from the repository.
     *
     * @param userName Username of the account to remove
     */
    public void removeUserAccount(String userName) {
        Optional<UserAccount> userAccountToRemove = findAccountByUsername(userName);
        if (userAccountToRemove.isPresent()) {
            userAccounts.remove(userAccountToRemove.get());
        } else {
            throw new AccountNotFoundException("Account to remove not found");
        }
    }

    public int getUsersCount() {
        return userAccounts.size();
    }

    /**
     * Removes all existing users.
     */
    public void clear() {
        userAccounts.clear();
    }

    /**
     * Retrieves all registered users.
     *
     * @return All registered users
     */
    public Iterable<UserAccount> getAll() {
        return Collections.unmodifiableSet(userAccounts);
    }
}
