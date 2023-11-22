package controller.command.administrator;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DeleteUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String identifier = request.getParameter("identifier");
        HttpSession httpSession = request.getSession();
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        employeeDAO.deleteUser(identifier);
        List<User> userList = employeeDAO.getUserList();
        request.setAttribute("userList", userList);
        page = ConfigurationManager.getProperty("path.page.admin.user_list");
        return page;
    }
}
