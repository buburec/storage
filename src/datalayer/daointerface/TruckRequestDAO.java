package datalayer.daointerface;

import datalayer.data.Request;
import datalayer.data.StorageTruckProduct;

import java.sql.Date;
import java.util.List;

/**
 * The TruckRequestDAO interface defines methods for interacting with truck request-related data in the database.
 */
public interface TruckRequestDAO {

    /**
     * Retrieves a list of active requests for a driver based on the provided host identifier.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Request objects representing active requests for the driver
     */
    List<Request> getDriverActiveRequestList(String hostIdentifier);

    /**
     * Retrieves a list of resolved requests for a driver based on the provided host identifier.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Request objects representing resolved requests for the driver
     */
    List<Request> getDriverResolvedRequestList(String hostIdentifier);

    /**
     * Retrieves a list of active requests for a storekeeper.
     *
     * @return a list of Request objects representing active requests for the storekeeper
     */
    List<Request> getStorekeeperActiveRequestList();

    /**
     * Retrieves a list of resolved requests for a storekeeper based on the provided resolver identifier.
     *
     * @param resolverIdentifier the identifier of the resolver (storekeeper)
     * @return a list of Request objects representing resolved requests for the storekeeper
     */
    List<Request> getStorekeeperResolvedRequestList(String resolverIdentifier);

    /**
     * Retrieves a list of storage truck products based on the provided host identifier.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of StorageTruckProduct objects representing storage truck products
     */
    List<StorageTruckProduct> getStorageTruckProductList(String hostIdentifier);

    /**
     * Retrieves information about a specific request based on the provided identifier.
     *
     * @param identifier the identifier of the request
     * @return a list of Request objects representing the requested information
     */
    List<Request> getRequest(int identifier);

    /**
     * Creates a new truck request with the specified action type and sent date.
     *
     * @param actionType the type of action for the request
     * @param sentDate   the date the request was sent
     */
    void createTruckRequest(String actionType, Date sentDate);

    /**
     * Updates a truck request with the specified truck identifier and commentary.
     *
     * @param truckIdentifier the identifier of the truck associated with the request
     * @param commentary      additional commentary for the request
     */
    void updateTruckRequest(String truckIdentifier, String commentary);

    /**
     * Deletes a truck request.
     */
    void deleteTruckRequest();

    /**
     * Updates the return waybill for a specific truck.
     *
     * @param truckIdentifier the identifier of the truck associated with the return waybill
     */
    void updateReturnWaybill(String truckIdentifier);

    /**
     * Deletes a truck request based on the provided request identifier.
     *
     * @param requestIdentifier the identifier of the request to be deleted
     */
    void deleteTruckRequest(int requestIdentifier);

    /**
     * Deletes a list of truck requests based on the provided request identifier.
     *
     * @param requestIdentifier the identifier of the request
     */
    void deleteTruckRequestList(int requestIdentifier);

    /**
     * Updates a truck request with the specified request identifier, resolver identifier, sent date, and status.
     *
     * @param requestIdentifier  the identifier of the request to be updated
     * @param resolverIdentifier the identifier of the resolver (storekeeper)
     * @param sentDate           the updated date the request was sent
     * @param status             the updated status of the request
     */
    void updateTruckRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, String status);

    /**
     * Updates the resolver response for a specific request.
     *
     * @param requestIdentifier the identifier of the request
     * @param resolverResponse  the resolver's response to the request
     */
    void updateResolverResponse(int requestIdentifier, String resolverResponse);
}
