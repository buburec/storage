package datalayer.data;

/**
 * The Waybill class represents information about a specific waybill, including the product identifier,
 * product title, quantity, and maximum quantity.
 */
public class Waybill {
    private int productIdentifier;
    private String productTitle;
    private int quantity;
    private int maxQuantity;

    /**
     * Constructs a new Waybill object with the specified product identifier, product title, and quantity.
     *
     * @param productIdentifier the identifier of the product in the waybill
     * @param productTitle      the title of the product in the waybill
     * @param quantity          the quantity of the product in the waybill
     */
    public Waybill(int productIdentifier, String productTitle, int quantity) {
        this.productIdentifier = productIdentifier;
        this.productTitle = productTitle;
        this.quantity = quantity;
    }

    /**
     * Constructs a new Waybill object with the specified product identifier and quantity.
     *
     * @param productIdentifier the identifier of the product in the waybill
     * @param quantity          the quantity of the product in the waybill
     */
    public Waybill(int productIdentifier, int quantity) {
        this.productIdentifier = productIdentifier;
        this.quantity = quantity;
    }

    /**
     * Gets the product identifier in the waybill.
     *
     * @return the product identifier in the waybill
     */
    public int getProductIdentifier() {
        return productIdentifier;
    }

    /**
     * Sets the product identifier in the waybill.
     *
     * @param productIdentifier the product identifier to be set
     */
    public void setProductIdentifier(int productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    /**
     * Gets the product title in the waybill.
     *
     * @return the product title in the waybill
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * Sets the product title in the waybill.
     *
     * @param productTitle the product title to be set
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    /**
     * Gets the quantity of the product in the waybill.
     *
     * @return the quantity of the product in the waybill
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in the waybill.
     *
     * @param quantity the quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the maximum quantity of the product in the waybill.
     *
     * @return the maximum quantity of the product in the waybill
     */
    public int getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * Sets the maximum quantity of the product in the waybill.
     *
     * @param maxQuantity the maximum quantity to be set
     */
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
