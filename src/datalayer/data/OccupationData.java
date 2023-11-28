package datalayer.data;

public class OccupationData {
    private int identifier;
    private String title;
    private String description;

    public OccupationData(int identifier, String title, String description) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
    }

    public String getIdentifier() {
        return String.format("%04d", identifier);
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
