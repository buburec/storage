package datalayer.data;

/**
 * The Occupation class represents information about a specific occupation, including the occupation's
 * identifier, title, and description.
 */
public class Occupation {
    private int identifier;
    private String title;
    private String description;

    /**
     * Constructs a new Occupation object with the specified identifier, title, and description.
     *
     * @param identifier  the identifier of the occupation
     * @param title       the title of the occupation
     * @param description the description of the occupation
     */
    public Occupation(int identifier, String title, String description) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the formatted identifier of the occupation.
     *
     * @return the formatted identifier of the occupation
     */
    public String getIdentifier() {
        return String.format("%04d", identifier);
    }

    /**
     * Sets the identifier of the occupation.
     *
     * @param identifier the identifier to be set
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the title of the occupation.
     *
     * @return the title of the occupation
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the occupation.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the occupation.
     *
     * @return the description of the occupation
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the occupation.
     *
     * @param description the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
