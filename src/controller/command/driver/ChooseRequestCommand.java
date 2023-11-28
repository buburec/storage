package controller.command.driver;

import controller.command.ActionCommand;
import controller.logic.TruckRequestLogicEnum;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckDAO;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Truck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

public class ChooseRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String actionType = request.getParameter("actionType");
        java.util.Date utilDate = Calendar.getInstance().getTime();
        java.sql.Date sentDate = new java.sql.Date(utilDate.getTime());
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("actionType", actionType);
        TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
        truckRequestDAO.createTruckRequest(actionType, sentDate);
        String hostIdentifier = (String) httpSession.getAttribute("identifier");
        TruckDAO truckDAO = (TruckDAO) httpSession.getAttribute("TruckDAO");
        List<Truck> truckIdentifierList =
                TruckRequestLogicEnum.getAvailableTruckList(truckDAO, hostIdentifier, actionType);
        request.setAttribute("truckIdentifierList", truckIdentifierList);
        page = ConfigurationManager.getProperty("path.page.driver.request_create");
        return page;
    }
}
