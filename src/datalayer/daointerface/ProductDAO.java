package datalayer.daointerface;

import datalayer.data.Product;

import java.util.List;

/**
 * The ProductDAO interface defines methods for interacting with product-related data in the database.
 */
public interface ProductDAO {

    /**
     * Retrieves a list of product titles.
     *
     * @return a list of Product objects representing product titles
     */
    List<Product> getProductTitleList();

    /**
     * Retrieves a list of used products.
     *
     * @return a list of Product objects representing used products
     */
    List<Product> getUsedProductList();

    /**
     * Retrieves a list of unused products.
     *
     * @return a list of Product objects representing unused products
     */
    List<Product> getUnusedProductList();

    /**
     * Creates a new product with the specified information.
     *
     * @param title       the title of the product
     * @param description the description of the product
     * @param price       the price of the product
     */
    void createProduct(String title, String description, float price);

    /**
     * Deletes a product based on the provided identifier.
     *
     * @param identifier the identifier of the product to be deleted
     */
    void deleteProduct(int identifier);
}
