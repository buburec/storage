package controller.command.administrator;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.OccupationDAO;
import datalayer.data.OccupationData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OccupationsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        OccupationDAO occupationDAO = (OccupationDAO) httpSession.getAttribute("OccupationDAO");
        List<OccupationData> occupationDataList = occupationDAO.getOccupationData();
        request.setAttribute("occupationDataList", occupationDataList);
        page = ConfigurationManager.getProperty("path.page.admin.occupation_list");
        return page;
    }
}