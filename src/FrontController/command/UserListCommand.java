package FrontController.command;

import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class UserListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.userlist");
    }
}
