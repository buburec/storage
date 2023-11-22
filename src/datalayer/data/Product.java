package datalayer.data;

public class Product {
    private int identifier;
    private String title;

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

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
}
