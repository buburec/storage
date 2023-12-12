package datalayer.data;

/**
 * The StorageProduct class represents information about a specific product in storage, including
 * the product's identifier, title, description, and quantity.
 */
public class StorageProduct {
    private int identifier;
    private String title;
    private String description;
    private int quantity;

    /**
     * Constructs a new StorageProduct object with the specified identifier, title, description, and quantity.
     *
     * @param identifier  the identifier of the storage product
     * @param title       the title of the storage product
     * @param description the description of the storage product
     * @param quantity    the quantity of the storage product
     */
    public StorageProduct(int identifier, String title, String description, int quantity) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * Gets the formatted identifier of the storage product.
     *
     * @return the formatted identifier of the storage product
     */
    public String getIdentifier() {
        return String.format("%08d", identifier);
    }

    /**
     * Sets the identifier of the storage product.
     *
     * @param identifier the identifier to be set
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the title of the storage product.
     *
     * @return the title of the storage product
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the storage product.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the storage product.
     *
     * @return the description of the storage product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the storage product.
     *
     * @param description the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the quantity of the storage product.
     *
     * @return the quantity of the storage product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the storage product.
     *
     * @param quantity the quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
