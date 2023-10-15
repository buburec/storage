package FrontController.command;

import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ProfileCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.profile");
    }
}