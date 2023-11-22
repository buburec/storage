package controller.command.administrator;

import controller.command.ActionCommand;
import controller.logic.CreateUserLogic;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CreateUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        int occupationIdentifier = CreateUserLogic.getOccupationIdentifier(request.getParameter("title"));

        HttpSession httpSession = request.getSession();
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");

        employeeDAO.createUser(identifier, password, fullName, occupationIdentifier);
        List<User> userList = employeeDAO.getUserList();
        String hostIdentifier = (String) httpSession.getAttribute("identifier");
        request.setAttribute("identifier", hostIdentifier);
        request.setAttribute("userList", userList);
        page = ConfigurationManager.getProperty("path.page.admin.user_list");
        return page;
    }
}
