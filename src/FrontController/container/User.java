package FrontController.container;

public class User {
    private int identifier;
    private String fullName;
    private String occupation;
    private String status;

    public User(int identifier, String fullName, String occupation, String status) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.occupation = occupation;
        this.status = status;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

