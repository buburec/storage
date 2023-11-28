package datalayer.data;

public class Waybill {
    private int productIdentifier;
    private String productTitle;
    private int quantity;
    private int maxQuantity;

    public Waybill(int productIdentifier, String productTitle, int quantity) {
        this.productIdentifier = productIdentifier;
        this.productTitle = productTitle;
        this.quantity = quantity;
    }

    public Waybill(int productIdentifier, int quantity) {
        this.productIdentifier = productIdentifier;
        this.quantity = quantity;
    }

    public int getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(int productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
