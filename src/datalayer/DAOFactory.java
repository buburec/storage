package datalayer;

import datalayer.daointerface.*;

public abstract class DAOFactory {
    public static DAOFactory getInstance(DBType dbType) {
        DAOFactory result = dbType.getDAOFactory();
        return result;
    }

    public void closeConnection() {

    }

    public abstract EmployeeDAO getEmployeeDAO();

    public abstract OccupationDAO getOccupationDAO();

    public abstract TruckRequestDAO getTruckRequestDAO();

    public abstract StorageProductDAO getStorageProductDAO();

    public abstract TruckMovementDAO getTruckMovementDAO();

    public abstract TruckDAO getTruckDAO();

    public abstract ProductDAO getProductDAO();
}
