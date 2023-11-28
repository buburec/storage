package datalayer.data;

public class Product {
    private int identifier;
    private String title;
    private String description;
    private float price;

    public Product(int identifier, String title, String description, float price) {
        this.identifier = identifier;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Product(int identifier, String title) {
        this.identifier = identifier;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return String.format("%08d", identifier);
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return String.format("%.2f", price);
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
