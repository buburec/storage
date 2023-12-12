package datalayer.data;

/**
 * The StorageTruckProduct class represents information about a specific product loaded on a truck, including
 * the truck identifier, product title, description, and quantity.
 */
public class StorageTruckProduct {
    private String truckIdentifier;
    private String title;
    private String description;
    private int quantity;

    /**
     * Constructs a new StorageTruckProduct object with the specified truck identifier, product title,
     * description, and quantity.
     *
     * @param truckIdentifier the identifier of the truck carrying the product
     * @param title           the title of the product on the truck
     * @param description     the description of the product on the truck
     * @param quantity        the quantity of the product on the truck
     */
    public StorageTruckProduct(String truckIdentifier, String title, String description, int quantity) {
        this.truckIdentifier = truckIdentifier;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * Gets the truck identifier associated with the product on the truck.
     *
     * @return the truck identifier associated with the product on the truck
     */
    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    /**
     * Sets the truck identifier associated with the product on the truck.
     *
     * @param truckIdentifier the truck identifier to be set
     */
    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }

    /**
     * Gets the title of the product on the truck.
     *
     * @return the title of the product on the truck
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the product on the truck.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the product on the truck.
     *
     * @return the description of the product on the truck
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product on the truck.
     *
     * @param description the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the quantity of the product on the truck.
     *
     * @return the quantity of the product on the truck
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product on the truck.
     *
     * @param quantity the quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
