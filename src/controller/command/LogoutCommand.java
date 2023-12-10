package controller.command;

import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        HttpSession httpSession = request.getSession(false);
        httpSession.invalidate();
        return page;
    }
}
