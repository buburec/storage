package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DriverRequestsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
        TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
        truckRequestDAO.deleteTruckRequest();
        List<Request> activeRequestList = truckRequestDAO.getDriverActiveRequestList(identifier);
        request.setAttribute("activeRequestList", activeRequestList);
        List<Request> resolvedRequestList = truckRequestDAO.getDriverResolvedRequestList(identifier);
        request.setAttribute("resolvedRequestList", resolvedRequestList);
        page = ConfigurationManager.getProperty("path.page.driver.request_list");
        return page;
    }
}
