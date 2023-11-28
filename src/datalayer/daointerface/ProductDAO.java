package datalayer.daointerface;

import datalayer.data.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductTitleList();

    List<Product> getProductList();

    void createProduct(String title, String description, float price);
}
