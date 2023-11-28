package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.StorageProductDAO;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.daointerface.TruckWaybillDAO;
import datalayer.data.Request;
import datalayer.data.Waybill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StorekeeperRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        int requestIdentifier = Integer.parseInt(request.getParameter("requestIdentifier"));
        TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
        List<Request> requestList = truckRequestDAO.getRequest(requestIdentifier);
        TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
        List<Waybill> waybillList = truckWaybillDAO.getTruckWaybill(requestIdentifier);
        StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
        List<Waybill> maxStorageProductList = storageProductDAO.getMaxStorageProductList(requestIdentifier);
        for (int i = 0; i < maxStorageProductList.size(); i++) {
            waybillList.get(i).setMaxQuantity(maxStorageProductList.get(i).getQuantity());
        }
        request.setAttribute("requestList", requestList);
        request.setAttribute("waybillList", waybillList);
        page = ConfigurationManager.getProperty("path.page.storekeeper.request");
        return page;
    }
}
