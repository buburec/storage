package controller.command.storekeeper;

import controller.command.ActionCommand;
import controller.logic.StorekeeperRequestLogicEnum;
import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

public class AcceptRequestCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        java.util.Date utilDate = Calendar.getInstance().getTime();
        java.sql.Date sentDate = new java.sql.Date(utilDate.getTime());
        HttpSession httpSession = request.getSession();
        int requestIdentifier = Integer.parseInt(request.getParameter("requestIdentifier"));
        String resolverIdentifier = (String) httpSession.getAttribute("identifier");
        String topic = request.getParameter("topic");
        StorekeeperRequestLogicEnum requestLogicEnum = StorekeeperRequestLogicEnum.valueOf(topic.toUpperCase());
        requestLogicEnum.acceptRequest(requestIdentifier, resolverIdentifier, sentDate, httpSession);
        request.setAttribute("requestIdentifier", requestIdentifier);
        page = ConfigurationManager.getProperty("path.page.storekeeper.request_response");
        return page;
    }
}
