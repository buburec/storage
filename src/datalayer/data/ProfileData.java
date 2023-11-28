package datalayer.data;

public class ProfileData {
    private String identifier;
    private String password;
    private String fullName;
    private String title;
    private String status;

    public ProfileData(String identifier, String password, String fullName, String title, String status) {
        this.identifier = identifier;
        this.password = password;
        this.fullName = fullName;
        this.title = title;
        this.status = status;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return this.title;
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

