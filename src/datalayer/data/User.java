package datalayer.data;

/**
 * The User class represents information about a specific user, including the user identifier,
 * full name, title, and status.
 */
public class User {
    private String identifier;
    private String fullName;
    private String title;
    private String status;

    /**
     * Constructs a new User object with the specified user identifier, full name, title, and status.
     *
     * @param identifier the identifier of the user
     * @param fullName   the full name of the user
     * @param title      the title of the user
     * @param status     the status of the user
     */
    public User(String identifier, String fullName, String title, String status) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.title = title;
        this.status = status;
    }

    /**
     * Gets the user identifier.
     *
     * @return the user identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the user identifier.
     *
     * @param identifier the user identifier to be set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the full name of the user.
     *
     * @return the full name of the user
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullName the full name to be set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the title of the user.
     *
     * @return the title of the user
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the user.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the status of the user.
     *
     * @return the status of the user
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the user.
     *
     * @param status the status to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
