package datalayer.data;

public class StorageProduct {
    private int identifier;
    private String title;
    private String description;
    private int quantity;

    public StorageProduct(int identifier, String title, String description, int quantity) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    public int getIdentifier() {
        return identifier;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
