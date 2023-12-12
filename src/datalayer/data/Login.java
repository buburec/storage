package datalayer.data;

/**
 * The Login class represents user login information, including the user's identifier, password,
 * occupation, and status.
 */
public class Login {
    private String identifier;
    private String password;
    private String occupation;
    private String status;

    /**
     * Constructs a new Login object with the specified identifier, password, occupation, and status.
     *
     * @param identifier the user identifier
     * @param password   the user password
     * @param occupation the user occupation
     * @param status     the user status
     */
    public Login(String identifier, String password, String occupation, String status) {
        this.identifier = identifier;
        this.password = password;
        this.occupation = occupation;
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
     * Gets the user password.
     *
     * @return the user password
     */
    public String getPassword() {
        return password;
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
     * Gets the user occupation.
     *
     * @return the user occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Sets the user occupation.
     *
     * @param occupation the user occupation to be set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Gets the user status.
     *
     * @return the user status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the user status.
     *
     * @param status the user status to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
