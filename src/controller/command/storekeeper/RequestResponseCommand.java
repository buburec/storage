package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RequestResponseCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        int requestIdentifier = Integer.parseInt(request.getParameter("requestIdentifier"));
        String resolverResponse = request.getParameter("resolverResponse");
        TruckRequestDAO truckRequestDAO = (TruckRequestDAO) httpSession.getAttribute("TruckRequestDAO");
        truckRequestDAO.updateResolverResponse(requestIdentifier, resolverResponse);
        String identifier = (String) httpSession.getAttribute("identifier");
        List<Request> resolvedRequestList = truckRequestDAO.getStorekeeperResolvedRequestList(identifier);
        request.setAttribute("resolvedRequestList", resolvedRequestList);
        List<Request> activeRequestList = truckRequestDAO.getStorekeeperActiveRequestList();
        request.setAttribute("activeRequestList", activeRequestList);
        page = ConfigurationManager.getProperty("path.page.storekeeper.request_list");
        return page;
    }
}
