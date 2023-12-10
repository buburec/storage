package controller.command.driver;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.daointerface.TruckDAO;
import datalayer.data.Profile;
import datalayer.data.Truck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateDriverProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        HttpSession httpSession = request.getSession();
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        employeeDAO.updateProfile(password, fullName, identifier);
        List<Profile> profile = employeeDAO.getProfile(identifier);
        request.setAttribute("profile", profile);
        TruckDAO truckDAO = (TruckDAO) httpSession.getAttribute("TruckDAO");
        List<Truck> insideTruckList = truckDAO.getInsideTruckList(identifier);
        List<Truck> outsideTruckList = truckDAO.getOutsideTruckList(identifier);
        request.setAttribute("insideTruckList", insideTruckList);
        request.setAttribute("outsideTruckList", outsideTruckList);
        page = ConfigurationManager.getProperty("path.page.driver.profile");
        return page;
    }
}
