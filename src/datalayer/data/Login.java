package datalayer.data;

public class Login {
    private String identifier;
    private String password;
    private String occupation;
    private String status;

    public Login(String identifier, String password, String occupation, String status) {
        this.identifier = identifier;
        this.password = password;
        this.occupation = occupation;
        this.status = status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
