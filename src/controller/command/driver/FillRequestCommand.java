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

public class FillRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        String truckIdentifier = request.getParameter("truckIdentifier");
        String commentary = request.getParameter("commentary");
        String actionType = (String) httpSession.getAttribute("actionType");
        httpSession.setAttribute("truckIdentifier", truckIdentifier);
        httpSession.setAttribute("commentary", commentary);
        List<Product> productList = TruckRequestLogicEnum.getAvailableProductList(httpSession, actionType);
        request.setAttribute("productList", productList);
        TruckWaybillDAO truckWaybillDAO = (TruckWaybillDAO) httpSession.getAttribute("TruckWaybillDAO");
        truckWaybillDAO.updateTruckWaybill(truckIdentifier);
        List<Waybill> waybillList = truckWaybillDAO.getTruckWaybill();
        request.setAttribute("waybillList", waybillList);
        request.setAttribute("actionType", actionType);
        page = ConfigurationManager.getProperty("path.page.driver.request_waybill");
        return page;
    }
}
