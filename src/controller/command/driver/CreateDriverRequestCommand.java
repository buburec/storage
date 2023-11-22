package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateDriverRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
//        TruckDAO truckDAO = (TruckDAO) httpSession.getAttribute("TruckDAO");
//        List<String> outsideTrucks = truckDAO.getOutsideTrucks(identifier);
//        request.setAttribute("outsideTrucks", outsideTrucks);
        page = ConfigurationManager.getProperty("path.page.driver.request_creating");
        return page;
    }
}
