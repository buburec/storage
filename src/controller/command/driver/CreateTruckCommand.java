package controller.command.driver;

import controller.command.ActionCommand;
import datalayer.daointerface.TruckDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateTruckCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        String identifier = request.getParameter("identifier");
        String model = request.getParameter("model");
        String hostIdentifier = (String) httpSession.getAttribute("identifier");
        TruckDAO truckDAO = (TruckDAO) httpSession.getAttribute("TruckDAO");
        truckDAO.createTruck(identifier, model, hostIdentifier);
        page = new DriverProfileCommand().execute(request);
        return page;
    }
}
