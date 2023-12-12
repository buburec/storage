package datalayer.daointerface;

import datalayer.data.Waybill;

import java.util.List;

/**
 * The TruckWaybillDAO interface defines methods for interacting with truck waybill-related data in the database.
 */
public interface TruckWaybillDAO {

    /**
     * Retrieves a list of all truck waybills.
     *
     * @return a list of Waybill objects representing all truck waybills
     */
    List<Waybill> getTruckWaybill();

    /**
     * Retrieves information about a specific truck waybill based on the provided identifier.
     *
     * @param identifier the identifier of the truck waybill
     * @return a list of Waybill objects representing the requested truck waybill information
     */
    List<Waybill> getTruckWaybill(int identifier);

    /**
     * Adds a product to the current waybill with the specified title and quantity.
     *
     * @param title    the title of the product
     * @param quantity the quantity of the product to be added
     */
    void addWaybillProduct(String title, int quantity);

    /**
     * Updates the quantity of a product in the current waybill with the specified title.
     *
     * @param title    the title of the product
     * @param quantity the updated quantity of the product
     * @return the updated quantity of the product in the waybill
     */
    int updateWaybillProduct(String title, int quantity);

    /**
     * Updates the current waybill for a specific truck.
     *
     * @param truckIdentifier the identifier of the truck associated with the current waybill
     */
    void updateCurrentWaybill(String truckIdentifier);

    /**
     * Updates the last accepted waybill based on the provided identifier.
     *
     * @param identifier the identifier of the last accepted waybill
     */
    void updateLastAcceptedWaybill(int identifier);

    /**
     * Deletes a product from the waybill based on the provided product identifier.
     *
     * @param productIdentifier the identifier of the product to be deleted from the waybill
     */
    void deleteWaybillProduct(int productIdentifier);

    /**
     * Deletes a truck waybill based on the provided identifier.
     *
     * @param identifier the identifier of the truck waybill to be deleted
     */
    void deleteTruckWaybill(int identifier);
}
