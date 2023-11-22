package datalayer.daointerface;

import datalayer.data.StorageTruckProduct;
import datalayer.data.TruckIdentifier;

import java.util.List;

public interface TruckMovementDAO {
    List<StorageTruckProduct> getStorageTruckProductList(String host_identifier);

    List<TruckIdentifier> getInsideTruckIdentifierList(String host_identifier);

    List<TruckIdentifier> getOutsideTruckIdentifierList(String host_identifier);
}
