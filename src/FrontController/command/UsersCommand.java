package FrontController.command;

import FrontController.container.User;
import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersCommand implements ActionCommand {
    private static final String PARAM_NAME_PAGE = "page";

    @Override
    public String execute(HttpServletRequest request) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(00000000, "John Doe", "Administrator", "online"));
        userList.add(new User(00000001, "Jane Smith", "Moderator", "offline"));
        userList.add(new User(00000002, "Alice Johnson", "Storekeeper", "offline"));
        userList.add(new User(00000003, "Bob Brown", "Driver", "offline"));
        request.setAttribute("userList", userList);
        request.setAttribute("user", 909);
        return ConfigurationManager.getProperty(request.getParameter(PARAM_NAME_PAGE));
    }
}
