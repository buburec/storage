package controller.logic;

import datalayer.DAOFactory;

import javax.servlet.http.HttpSession;

public class DAOLogic {

    public static void setAdministratorDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("EmployeeDAO", factory.getEmployeeDAO());
        httpSession.setAttribute("OccupationDAO", factory.getOccupationDAO());
    }

    public static void setDriverDAO(HttpSession httpSession, DAOFactory factory) {
        httpSession.setAttribute("TruckRequestDAO", factory.getTruckRequestDAO());
        httpSession.setAttribute("StorageProductDAO", factory.getStorageProductDAO());
        httpSession.setAttribute("TruckMovementDAO", factory.getTruckMovementDAO());
//        httpSession.setAttribute("TruckDAO", factory.getTruckDAO());
        httpSession.setAttribute("ProductDAO", factory.getProductDAO());
    }
}
