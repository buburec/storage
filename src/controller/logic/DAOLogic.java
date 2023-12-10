package controller.logic;

import datalayer.DAOFactory;
import datalayer.DBType;

import javax.servlet.http.HttpSession;

public class DAOLogic {
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);

    public static DAOFactory getFactory() {
        return DAOLogic.factory;
    }

    public static void setAdministratorDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("EmployeeDAO", factory.getEmployeeDAO());
        httpSession.setAttribute("OccupationDAO", factory.getOccupationDAO());
    }

    public static void setModeratorDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("EmployeeDAO", factory.getEmployeeDAO());
        httpSession.setAttribute("OccupationDAO", factory.getOccupationDAO());
        httpSession.setAttribute("ProductDAO", factory.getProductDAO());
    }

    public static void setDriverDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("EmployeeDAO", factory.getEmployeeDAO());
        httpSession.setAttribute("TruckRequestDAO", factory.getTruckRequestDAO());
        httpSession.setAttribute("StorageProductDAO", factory.getStorageProductDAO());
        httpSession.setAttribute("TruckDAO", factory.getTruckDAO());
        httpSession.setAttribute("ProductDAO", factory.getProductDAO());
        httpSession.setAttribute("TruckWaybillDAO", factory.getTruckWaybillDAO());
    }

    public static void setStorekeeperDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("EmployeeDAO", factory.getEmployeeDAO());
        httpSession.setAttribute("TruckRequestDAO", factory.getTruckRequestDAO());
        httpSession.setAttribute("StorageProductDAO", factory.getStorageProductDAO());
        httpSession.setAttribute("TruckDAO", factory.getTruckDAO());
        httpSession.setAttribute("TruckWaybillDAO", factory.getTruckWaybillDAO());
    }
}
