package FrontController.command;

import FrontController.container.Request;
import FrontController.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestsCommand implements ActionCommand {
    private static final String PARAM_NAME_PAGE = "page";

    @Override
    public String execute(HttpServletRequest request) {
        List<Request> requestList = new ArrayList<>();
        requestList.add(new Request(0000000000, "Heavy-Duty Transporter XZ-2000", "Entry", "20.10.2023", "Resolver: Alice Johnson", "accepted"));
        requestList.add(new Request(0_000_000_001, "Heavy-Duty Transporter XZ-2000", "Unloading", "28.10.2023", "Resolver: none", "sent"));
        request.setAttribute("requestList", requestList);
        return ConfigurationManager.getProperty(request.getParameter(PARAM_NAME_PAGE));
    }
}
