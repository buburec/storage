package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.logic.StorekeeperRequestLogicEnum;
import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AcceptRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        int requestIdentifier = Integer.parseInt(request.getParameter("requestIdentifier"));
        String topic = request.getParameter("topic");
        StorekeeperRequestLogicEnum requestLogicEnum = StorekeeperRequestLogicEnum.valueOf(topic.toUpperCase());
        requestLogicEnum.acceptRequest(requestIdentifier, httpSession);
        request.setAttribute("requestIdentifier", requestIdentifier);
        page = ConfigurationManager.getProperty("path.page.storekeeper.request_response");
        return page;
    }
}
