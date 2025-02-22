package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StorekeeperRequestsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
        TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
        List<Request> resolvedRequestList = truckRequestDAO.getStorekeeperResolvedRequestList(identifier);
        request.setAttribute("resolvedRequestList", resolvedRequestList);
        List<Request> activeRequestList = truckRequestDAO.getStorekeeperActiveRequestList();
        request.setAttribute("activeRequestList", activeRequestList);
        page = ConfigurationManager.getProperty("path.page.storekeeper.request_list");
        return page;
    }
}
