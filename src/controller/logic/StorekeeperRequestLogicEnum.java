package controller.logic;

import datalayer.daointerface.StorageProductDAO;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.daointerface.TruckWaybillDAO;
import datalayer.data.Waybill;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

public enum StorekeeperRequestLogicEnum {
    ENTRY {
        @Override
        public void acceptRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "accepted");
        };

        @Override
        public void declineRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "declined");
            TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
            truckWaybillDAO.deleteTruckWaybill(requestIdentifier);
        }
    },
    LOADING {
        @Override
        public void acceptRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "accepted");
            StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
            List<Waybill> storageProductList = storageProductDAO.getAcceptLoadingProductList(requestIdentifier);
            storageProductDAO.deleteStorageProductList(requestIdentifier);
            for (Waybill waybill : storageProductList) {
                storageProductDAO.insertStorageProductList(waybill);
            }
        }

        @Override
        public void declineRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "declined");
            TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
            truckWaybillDAO.deleteTruckWaybill(requestIdentifier);
        }
    },
    EXIT {
        @Override
        public void acceptRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.deleteTruckRequestList(requestIdentifier);
        }

        @Override
        public void declineRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "declined");
            TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
            truckWaybillDAO.updateLastAcceptedWaybill(requestIdentifier);
        }
    },
    UNLOADING {
        @Override
        public void acceptRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier, resolverIdentifier, sentDate, "accepted");
            StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
            List<Waybill> storageProductList = storageProductDAO.getAcceptUnloadingProductList(requestIdentifier);
            storageProductDAO.deleteStorageProductList(requestIdentifier);
            for (Waybill waybill : storageProductList) {
                storageProductDAO.insertStorageProductList(waybill);
            }
            TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
            truckWaybillDAO.deleteTruckWaybill(requestIdentifier);
        }

        @Override
        public void declineRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession) {
            TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
            truckRequestDAO.updateTruckRequest(requestIdentifier,resolverIdentifier, sentDate, "declined");
            TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
            truckWaybillDAO.updateLastAcceptedWaybill(requestIdentifier);
        }
    };

    public abstract void acceptRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession);
    public abstract void declineRequest(int requestIdentifier, String resolverIdentifier, Date sentDate, HttpSession httpSession);
}
