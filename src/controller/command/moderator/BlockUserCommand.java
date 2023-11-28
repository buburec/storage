package controller.command.moderator;

import controller.command.ActionCommand;
import controller.logic.BlockUserLogicEnum;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BlockUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        String userIdentifier = request.getParameter("identifier");
        String status = BlockUserLogicEnum.changeUserStatus(request.getParameter("status"));
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        employeeDAO.updateStatus(status, userIdentifier);
        List<User> userList = employeeDAO.getUserList();
        String identifier = (String) httpSession.getAttribute("identifier");
        request.setAttribute("identifier", identifier);
        request.setAttribute("userList", userList);
        page = ConfigurationManager.getProperty("path.page.moderator.user_list");
        return page;
    }
}
