package controller.command.driver;

import controller.command.ActionCommand;
import controller.logic.TruckRequestLogicEnum;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckWaybillDAO;
import datalayer.data.Product;
import datalayer.data.Waybill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteWaybillProductCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
        int productIdentifier = Integer.parseInt(request.getParameter("productIdentifier"));
        truckWaybillDAO.deleteWaybillProduct(productIdentifier);
        String actionType = (String) httpSession.getAttribute("actionType");
        TruckRequestLogicEnum requestLogicEnum = TruckRequestLogicEnum.valueOf(actionType.toUpperCase());
        List<Product> productList = requestLogicEnum.getAvailableProductList(httpSession);
        request.setAttribute("productList", productList);
        List<Waybill> waybillList = truckWaybillDAO.getTruckWaybill();
        request.setAttribute("waybillList", waybillList);
        request.setAttribute("actionType", actionType);
        page = ConfigurationManager.getProperty("path.page.driver.request_waybill");
        return page;
    }
}
