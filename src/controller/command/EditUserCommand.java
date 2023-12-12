package controller.command;

import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.Profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class EditUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String identifier = request.getParameter("user_identifier");
        HttpSession httpSession = request.getSession();
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        List<Profile> profile = employeeDAO.getProfile(identifier);
        request.setAttribute("profile", profile);
        page = ConfigurationManager.getProperty(request.getParameter("page"));
        return page;
    }
}
