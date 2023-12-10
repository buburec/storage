package datalayer.daointerface;

import datalayer.data.Request;
import datalayer.data.StorageTruckProduct;

import java.sql.Date;
import java.util.List;

public interface TruckRequestDAO {
    List<Request> getDriverActiveRequestList(String hostIdentifier);

    List<Request> getDriverResolvedRequestList(String hostIdentifier);

    List<Request> getStorekeeperActiveRequestList();

    List<Request> getStorekeeperResolvedRequestList(String resolverIdentifier);

    List<StorageTruckProduct> getStorageTruckProductList(String host_identifier);

    List<Request> getRequest(int identifier);

    void createTruckRequest(String actionType, Date sentDate);

    void updateTruckRequest(String truckIdentifier, String commentary);

    void deleteTruckRequest();

    void updateReturnWaybill(String truckIdentifier);

    void deleteTruckRequest(int requestIdentifier);

    void deleteTruckRequestList(int requestIdentifier);

    void updateTruckRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, String status);

    void updateResolverResponse(int requestIdentifier, String resolverResponse);
}
