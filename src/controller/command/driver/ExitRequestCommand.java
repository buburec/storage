package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckMovementDAO;
import datalayer.data.TruckIdentifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ExitRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
//        Calendar calendar = Calendar.getInstance();
//        java.util.Date utilDate = calendar.getTime();
//        java.sql.Date sentDate = new java.sql.Date(utilDate.getTime());
        TruckMovementDAO truckMovementDAO = (TruckMovementDAO) httpSession.getAttribute("TruckMovementDAO");
        String host_identifier = (String) httpSession.getAttribute("identifier");
        List<TruckIdentifier> truckIdentifierList = truckMovementDAO.getOutsideTruckIdentifierList(host_identifier);
        request.setAttribute("truckIdentifierList", truckIdentifierList);
//        String truckIdentifier = request.getParameter("truckIdentifier");
//        String commentary = request.getParameter("commentary");
        page = ConfigurationManager.getProperty("path.page.driver.request_creating");
        return page;
    }
}
