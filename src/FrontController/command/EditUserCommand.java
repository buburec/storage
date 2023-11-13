package FrontController.command;

import FrontController.container.User;
import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EditUserCommand implements  ActionCommand {
    private static final String PARAM_NAME_PAGE = "page";
    @Override
    public String execute(HttpServletRequest request) {
        int identifier = Integer.parseInt(request.getParameter("user_identifier"));
        String fullName = request.getParameter("user_fullName");
        String occupation = request.getParameter("user_occupation");
        String status = request.getParameter("user_status");
        request.setAttribute("user", new User(identifier, fullName, occupation, status));
        String visibility = request.getParameter("visibility");
        request.setAttribute("visibility", visibility);
        return ConfigurationManager.getProperty(request.getParameter(PARAM_NAME_PAGE));
    }
}
