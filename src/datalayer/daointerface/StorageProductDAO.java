package datalayer.daointerface;

import datalayer.data.Product;
import datalayer.data.StorageProduct;
import datalayer.data.Waybill;

import java.util.List;

/**
 * The StorageProductDAO interface defines methods for interacting with storage product-related data in the database.
 */
public interface StorageProductDAO {

    /**
     * Retrieves a list of storage products associated with a driver.
     *
     * @return a list of StorageProduct objects representing storage products for a driver
     */
    List<StorageProduct> getDriverStorageProductList();

    /**
     * Retrieves a list of product titles.
     *
     * @return a list of Product objects representing product titles
     */
    List<Product> getProductTitleList();

    /**
     * Retrieves a list of waybills for accepting loading products based on the provided request identifier.
     *
     * @param requestIdentifier the identifier of the request
     * @return a list of Waybill objects representing accepted loading products
     */
    List<Waybill> getAcceptLoadingProductList(int requestIdentifier);

    /**
     * Retrieves a list of waybills for accepting unloading products based on the provided request identifier.
     *
     * @param requestIdentifier the identifier of the request
     * @return a list of Waybill objects representing accepted unloading products
     */
    List<Waybill> getAcceptUnloadingProductList(int requestIdentifier);

    /**
     * Deletes storage products based on the provided request identifier.
     *
     * @param requestIdentifier the identifier of the request
     */
    void deleteStorageProductList(int requestIdentifier);

    /**
     * Inserts storage products into the database based on the provided waybill.
     *
     * @param waybill the Waybill object representing the waybill for storage product insertion
     */
    void insertStorageProductList(Waybill waybill);

    /**
     * Retrieves a list of waybills with the maximum storage products for a given request identifier.
     *
     * @param requestIdentifier the identifier of the request
     * @return a list of Waybill objects representing waybills with the maximum storage products
     */
    List<Waybill> getMaxStorageProductList(int requestIdentifier);
}
