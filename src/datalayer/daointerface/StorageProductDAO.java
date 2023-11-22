package datalayer.daointerface;

import datalayer.data.StorageProduct;

import java.util.List;

public interface StorageProductDAO {
    List<StorageProduct> getDriverStorageProductList();
}
