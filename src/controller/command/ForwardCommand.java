package controller.command;

import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ForwardCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
        request.setAttribute("identifier", identifier);
        return ConfigurationManager.getProperty(request.getParameter("page"));
    }
}
