package datalayer.daointerface;

import datalayer.data.Truck;

import java.util.List;

/**
 * The TruckDAO interface defines methods for interacting with truck-related data in the database.
 */
public interface TruckDAO {

    /**
     * Retrieves a list of truck identifiers that are currently inside a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing inside trucks
     */
    List<Truck> getInsideTruckIdentifierList(String hostIdentifier);

    /**
     * Retrieves a list of truck identifiers that are currently outside a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing outside trucks
     */
    List<Truck> getOutsideTruckIdentifierList(String hostIdentifier);

    /**
     * Retrieves a list of truck identifiers that are currently loaded at a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing loaded trucks
     */
    List<Truck> getLoadedTruckIdentifierList(String hostIdentifier);

    /**
     * Retrieves a list of truck identifiers that are currently unloaded at a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing unloaded trucks
     */
    List<Truck> getUnloadedTruckIdentifierList(String hostIdentifier);

    /**
     * Retrieves a list of all trucks that are currently inside any location.
     *
     * @return a list of Truck objects representing all inside trucks
     */
    List<Truck> getInsideTruckList();

    /**
     * Retrieves a list of trucks that are currently inside a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing inside trucks at the specified location
     */
    List<Truck> getInsideTruckList(String hostIdentifier);

    /**
     * Retrieves a list of trucks that are currently outside a specific location identified by the host.
     *
     * @param hostIdentifier the identifier of the host location
     * @return a list of Truck objects representing outside trucks at the specified location
     */
    List<Truck> getOutsideTruckList(String hostIdentifier);

    /**
     * Creates a new truck with the specified information.
     *
     * @param identifier     the identifier of the truck
     * @param model          the model of the truck
     * @param hostIdentifier the identifier of the host location
     */
    void createTruck(String identifier, String model, String hostIdentifier);

    /**
     * Deletes a truck based on the provided identifier.
     *
     * @param identifier the identifier of the truck to be deleted
     */
    void deleteTruck(String identifier);
}
