package controller.command;

import controller.logic.DAOLogic;
import controller.logic.LoginLogic;
import controller.resource.ConfigurationManager;
import controller.resource.MessageManager;
import datalayer.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private final static String ADMIN_ROLE = "Administrator";
    private final static String MODERATOR_ROLE = "Moderator";
    private final static String DRIVER_ROLE = "Driver";
    private final static String STOREKEEPER_ROLE = "Storekeeper";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        LoginLogic.setLoginDataList(login, pass);
        HttpSession httpSession = request.getSession();
        DAOFactory factory = LoginLogic.getFactory();
        switch (LoginLogic.getOccupationTitle()) {
            case LoginCommand.ADMIN_ROLE:
                if (LoginLogic.isUserBlocked()) {
                    page = ConfigurationManager.getProperty("path.page.blocked");
                } else {
                    httpSession.setAttribute("identifier", login);
                    LoginLogic.setStatus("online", login);
                    DAOLogic.setAdministratorDAO(httpSession, factory);
                    page = ConfigurationManager.getProperty("path.page.admin.welcome");
                }
                break;
            case LoginCommand.MODERATOR_ROLE:
                if (LoginLogic.isUserBlocked()) {
                    page = ConfigurationManager.getProperty("path.page.blocked");
                } else {
                    httpSession.setAttribute("identifier", login);
                    LoginLogic.setStatus("online", login);
                    DAOLogic.setModeratorDAO(httpSession, factory);
                    page = ConfigurationManager.getProperty("path.page.moderator.welcome");
                }
                break;
            case LoginCommand.DRIVER_ROLE:
                if (LoginLogic.isUserBlocked()) {
                    page = ConfigurationManager.getProperty("path.page.blocked");
                } else {
                    httpSession.setAttribute("identifier", login);
                    LoginLogic.setStatus("online", login);
                    DAOLogic.setDriverDAO(httpSession, factory);
                    page = ConfigurationManager.getProperty("path.page.driver.welcome");
                }
                break;
            case LoginCommand.STOREKEEPER_ROLE:
                if (LoginLogic.isUserBlocked()) {
                    page = ConfigurationManager.getProperty("path.page.blocked");
                } else {
                    httpSession.setAttribute("identifier", login);
                    LoginLogic.setStatus("online", login);
                    DAOLogic.setStorekeeperDAO(httpSession, factory);
                    page = ConfigurationManager.getProperty("path.page.storekeeper.welcome");
                }
                break;
            default:
                request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
//            page = ConfigurationManager.getProperty("path.page.login");
                break;
        }
        return page;
    }
}
