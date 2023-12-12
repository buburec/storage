package controller.command;

import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();

        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        List<User> userList = employeeDAO.getUserList();

        String identifier = (String) httpSession.getAttribute("identifier");
        request.setAttribute("identifier", identifier);
        request.setAttribute("userList", userList);
        page = ConfigurationManager.getProperty(request.getParameter("page"));
        return page;
    }
}
