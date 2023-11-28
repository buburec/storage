package controller.command.administrator;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.ProfileData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        HttpSession httpSession = request.getSession();
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        employeeDAO.updateProfile(password, fullName, identifier);
        List<ProfileData> profile = employeeDAO.getProfile(identifier);
        request.setAttribute("profile", profile);
        page = ConfigurationManager.getProperty("path.page.driver.");
        return page;
    }
}
