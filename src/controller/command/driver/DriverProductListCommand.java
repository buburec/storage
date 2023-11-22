package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.StorageProductDAO;
import datalayer.daointerface.TruckMovementDAO;
import datalayer.data.StorageProduct;
import datalayer.data.StorageTruckProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DriverProductListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        StorageProductDAO storageProductDAO = (StorageProductDAO) httpSession.getAttribute("StorageProductDAO");
        List<StorageProduct> storageProductList = storageProductDAO.getDriverStorageProductList();
        request.setAttribute("storageProductList", storageProductList);
        String identifier = (String) httpSession.getAttribute("identifier");
        TruckMovementDAO truckMovementDAO = (TruckMovementDAO) httpSession.getAttribute("TruckMovementDAO");
        List<StorageTruckProduct> storageTruckProductList = truckMovementDAO.getStorageTruckProductList(identifier);
        request.setAttribute("storageTruckProductList", storageTruckProductList);
        page = ConfigurationManager.getProperty("path.page.driver.product_list");
        return page;
    }
}
