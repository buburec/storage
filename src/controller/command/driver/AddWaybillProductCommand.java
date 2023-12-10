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

public class AddWaybillProductCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
        String title = request.getParameter("title");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        TruckRequestLogicEnum.addWaybillProduct(truckWaybillDAO, title, quantity);
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
