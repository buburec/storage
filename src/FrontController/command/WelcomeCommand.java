package FrontController.command;

import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class WelcomeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.welcome");
    }
}
