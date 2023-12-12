package datalayer.data;

/**
 * The Profile class represents user profile information, including the user's identifier, password,
 * full name, title, and status.
 */
public class Profile {
    private String identifier;
    private String password;
    private String fullName;
    private String title;
    private String status;

    /**
     * Constructs a new Profile object with the specified identifier, password, full name, title, and status.
     *
     * @param identifier the user identifier
     * @param password   the user password
     * @param fullName   the user's full name
     * @param title      the user's title
     * @param status     the user's status
     */
    public Profile(String identifier, String password, String fullName, String title, String status) {
        this.identifier = identifier;
        this.password = password;
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
        return this.identifier;
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
     * Gets the user password.
     *
     * @return the user password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the user password.
     *
     * @param password the user password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's full name.
     *
     * @return the user's full name
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Sets the user's full name.
     *
     * @param fullName the user's full name to be set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the user's title.
     *
     * @return the user's title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the user's title.
     *
     * @param title the user's title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the user's status.
     *
     * @return the user's status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the user's status.
     *
     * @param status the user's status to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
