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
        @Override
        public List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier) {
            return truckDAO.getOutsideTruckIdentifierList(hostIdentifier);
        }

        @Override
        public List<Product> getAvailableProductList(HttpSession httpSession) {
            ProductDAO productDAO = (ProductDAO) httpSession.getAttribute("ProductDAO");
            return productDAO.getProductTitleList();
        }
    },
    EXIT {
        @Override
        public List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier) {
            return truckDAO.getInsideTruckIdentifierList(hostIdentifier);
        }

        @Override
        public List<Product> getAvailableProductList(HttpSession httpSession) {
            return null;
        }
    },
    LOADING {
        @Override
        public List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier) {
            return truckDAO.getUnloadedTruckIdentifierList(hostIdentifier);
        }

        @Override
        public List<Product> getAvailableProductList(HttpSession httpSession) {
            StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
            return storageProductDAO.getProductTitleList();
        }
    },
    UNLOADING {
        @Override
        public List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier) {
            return truckDAO.getLoadedTruckIdentifierList(hostIdentifier);
        }

        @Override
        public List<Product> getAvailableProductList(HttpSession httpSession) {
            return null;
        }
    };

    public abstract List<Truck> getAvailableTruckList(TruckDAO truckDAO, String hostIdentifier);

    public abstract List<Product> getAvailableProductList(HttpSession httpSession);

    public static void addWaybillProduct(TruckWaybillDAO truckWaybillDAO, String title, int quantity) {
        if (truckWaybillDAO.updateWaybillProduct(title, quantity) == 0) {
            truckWaybillDAO.addWaybillProduct(title, quantity);
        }
    }
}
