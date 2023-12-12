package datalayer.daointerface;

import datalayer.data.Login;
import datalayer.data.Profile;
import datalayer.data.User;

import java.util.List;

/**
 * The EmployeeDAO interface defines methods for interacting with employee-related data in the database.
 */
public interface EmployeeDAO {

    /**
     * Retrieves login data for a user based on the provided identifier and password.
     *
     * @param identifier the user identifier
     * @param password   the user password
     * @return a list of Login objects representing the user's login data
     */
    List<Login> getLoginData(String identifier, String password);

    /**
     * Retrieves profile data for a user based on the provided identifier.
     *
     * @param identifier the user identifier
     * @return a list of Profile objects representing the user's profile data
     */
    List<Profile> getProfile(String identifier);

    /**
     * Creates a new user with the specified information.
     *
     * @param identifier          the user identifier
     * @param password            the user password
     * @param fullName            the user's full name
     * @param occupationIdentifier the identifier of the user's occupation
     */
    void createUser(String identifier, String password, String fullName, int occupationIdentifier);

    /**
     * Deletes a user based on the provided identifier.
     *
     * @param identifier the user identifier
     */
    void deleteUser(String identifier);

    /**
     * Updates the profile of a user with the specified information.
     *
     * @param password   the updated user password
     * @param fullName   the updated user's full name
     * @param identifier the user identifier
     */
    void updateProfile(String password, String fullName, String identifier);

    /**
     * Updates the status of a user based on the provided identifier.
     *
     * @param status     the updated user status
     * @param identifier the user identifier
     */
    void updateStatus(String status, String identifier);

    /**
     * Retrieves a list of all users.
     *
     * @return a list of User objects representing all users
     */
    List<User> getUserList();
}
