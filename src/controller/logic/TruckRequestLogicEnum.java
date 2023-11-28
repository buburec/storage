package controller.logic;

import datalayer.daointerface.ProductDAO;
import datalayer.daointerface.StorageProductDAO;
import datalayer.daointerface.TruckDAO;
import datalayer.daointerface.TruckWaybillDAO;
import datalayer.data.Product;
import datalayer.data.Truck;

import javax.servlet.http.HttpSession;
import java.util.List;

public enum TruckRequestLogicEnum {

    ENTRY {

    },
    EXIT {

    },
    LOADING {

    },
    UNLOADING {

    };

    public static List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier, String actionType) {
        if (TruckRequestLogicEnum.valueOf(actionType.toUpperCase()).equals(TruckRequestLogicEnum.ENTRY)) {
            return truckDAO.getOutsideTruckIdentifierList(hostIdentifier);
        }
        return truckDAO.getInsideTruckIdentifierList(hostIdentifier);
    }

    public static List<Product> getAvailableProductList(HttpSession httpSession, String actionType) {
        if (TruckRequestLogicEnum.valueOf(actionType.toUpperCase()).equals(TruckRequestLogicEnum.ENTRY)) {
            ProductDAO productDAO = (ProductDAO) httpSession.getAttribute("ProductDAO");
            return productDAO.getProductTitleList();
        }
        if (TruckRequestLogicEnum.valueOf(actionType.toUpperCase()).equals(TruckRequestLogicEnum.LOADING)) {
            StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
            return storageProductDAO.getProductTitleList();
        }
        return null;
    }

    public static void addWaybillProduct(TruckWaybillDAO truckWaybillDAO, String title, int quantity) {
        if (truckWaybillDAO.updateWaybillProduct(title, quantity) == 0) {
            truckWaybillDAO.addWaybillProduct(title, quantity);
        }
    }
}
