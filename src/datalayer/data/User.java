package datalayer.data;

public class User {
    private String identifier;
    private String fullName;
    private String title;
    private String status;

    public User(String identifier, String fullName, String title, String status) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.title = title;
        this.status = status;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
