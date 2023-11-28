package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.daointerface.TruckDAO;
import datalayer.data.ProfileData;
import datalayer.data.Truck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        List<ProfileData> profile = employeeDAO.getProfile(hostIdentifier);
        request.setAttribute("profile", profile);
        List<Truck> insideTruckList = truckDAO.getInsideTruckList(identifier);
        List<Truck> outsideTruckList = truckDAO.getOutsideTruckList(identifier);
        request.setAttribute("insideTruckList", insideTruckList);
        request.setAttribute("outsideTruckList", outsideTruckList);
        page = ConfigurationManager.getProperty("path.page.driver.profile");
        return page;
    }
}
