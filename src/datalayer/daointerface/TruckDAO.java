package datalayer.daointerface;

import datalayer.data.Truck;

import java.util.List;

public interface TruckDAO {
    List<Truck> getInsideTruckIdentifierList(String hostIdentifier);

    List<Truck> getOutsideTruckIdentifierList(String hostIdentifier);

    List<Truck> getLoadedTruckIdentifierList(String hostIdentifier);

    List<Truck> getUnloadedTruckIdentifierList(String hostIdentifier);

    List<Truck> getInsideTruckList();

    List<Truck> getInsideTruckList(String hostIdentifier);

    List<Truck> getOutsideTruckList(String hostIdentifier);

    void createTruck(String identifier, String model, String hostIdentifier);

}
