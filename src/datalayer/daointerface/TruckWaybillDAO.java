package datalayer.daointerface;

import datalayer.data.Waybill;

import java.util.List;

public interface TruckWaybillDAO {
    List<Waybill> getTruckWaybill();

    List<Waybill> getTruckWaybill(int identifier);

    void addWaybillProduct(String title, int quantity);

    int updateWaybillProduct(String title, int quantity);

    void updateTruckWaybill(String truckIdentifier);

    void updateEntryWaybill(int identifier);

    void deleteWaybillProduct(int productIdentifier);

    void deleteTruckWaybill(int identifier);

}
