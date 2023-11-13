package FrontController.command;

import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ForwardCommand implements ActionCommand {
    private static final String PARAM_NAME_PAGE = "page";
    @Override
    public String execute(HttpServletRequest request) {
        String visibility = request.getParameter("visibility");
        request.setAttribute("visibility", visibility);
        return ConfigurationManager.getProperty(request.getParameter(PARAM_NAME_PAGE));
    }
}
