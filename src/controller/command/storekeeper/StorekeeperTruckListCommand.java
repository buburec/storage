package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.TruckDAO;
import datalayer.data.Truck;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StorekeeperTruckListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        TruckDAO truckDAO = (TruckDAO) httpSession.getAttribute("TruckDAO");
        List<Truck> truckList = truckDAO.getInsideTruckList();
        request.setAttribute("truckList", truckList);
        page = ConfigurationManager.getProperty("path.page.storekeeper.truck_list");
        return page;
    }
}
