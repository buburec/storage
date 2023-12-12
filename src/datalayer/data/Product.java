package datalayer.data;

/**
 * The Product class represents information about a specific product, including the product's
 * identifier, title, description, and price.
 */
public class Product {
    private int identifier;
    private String title;
    private String description;
    private float price;

    /**
     * Constructs a new Product object with the specified identifier, title, description, and price.
     *
     * @param identifier  the identifier of the product
     * @param title       the title of the product
     * @param description the description of the product
     * @param price       the price of the product
     */
    public Product(int identifier, String title, String description, float price) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    /**
     * Constructs a new Product object with the specified identifier and title.
     *
     * @param identifier the identifier of the product
     * @param title      the title of the product
     */
    public Product(int identifier, String title) {
        this.identifier = identifier;
        this.title = title;
    }

    /**
     * Gets the title of the product.
     *
     * @return the title of the product
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the product.
     *
     * @param title the title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the formatted identifier of the product.
     *
     * @return the formatted identifier of the product
     */
    public String getIdentifier() {
        return String.format("%08d", identifier);
    }

    /**
     * Sets the identifier of the product.
     *
     * @param identifier the identifier to be set
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the description of the product.
     *
     * @return the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the formatted price of the product.
     *
     * @return the formatted price of the product
     */
    public String getPrice() {
        return String.format("%.2f", price);
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to be set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
