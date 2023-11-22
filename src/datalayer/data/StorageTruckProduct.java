package datalayer.data;

public class StorageTruckProduct {
    private String truckIdentifier;
    private String title;
    private String description;
    private int quantity;

    public StorageTruckProduct(String truckIdentifier, String title, String description, int quantity) {
        this.truckIdentifier = truckIdentifier;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
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
