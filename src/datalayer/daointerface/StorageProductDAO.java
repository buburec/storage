package datalayer.daointerface;

import datalayer.data.Product;
import datalayer.data.StorageProduct;
import datalayer.data.Waybill;

import java.util.List;

public interface StorageProductDAO {
    List<StorageProduct> getDriverStorageProductList();

    List<Product> getProductTitleList();

    List<Waybill> getAcceptLoadingProductList(int requestIdentifier);

    List<Waybill> getAcceptUnloadingProductList(int requestIdentifier);

    void deleteStorageProductList(int requestIdentifier);

    void insertStorageProductList(Waybill waybill);

    List<Waybill> getMaxStorageProductList(int requestIdentifier);

}
