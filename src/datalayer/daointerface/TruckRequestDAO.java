package datalayer.daointerface;

import datalayer.data.Request;
import datalayer.data.StorageTruckProduct;

import java.sql.Date;
import java.util.List;

public interface TruckRequestDAO {
    List<Request> getDriverRequestList(String hostIdentifier);

    List<Request> getStorekeeperRequestList(String resolverIdentifier);

    List<StorageTruckProduct> getStorageTruckProductList(String host_identifier);

    List<Request> getRequest(int identifier);

    void createTruckRequest(String actionType, Date sentDate);

    void updateTruckRequest(String truckIdentifier, String commentary);

    void deleteTruckRequest();

    void deleteTruckRequest(int requestIdentifier);

    void deleteTruckRequestList(int requestIdentifier);

    void updateTruckRequestStatus(int requestIdentifier, String status);

    void updateResolverResponse(int requestIdentifier, String resolverResponse);
}
