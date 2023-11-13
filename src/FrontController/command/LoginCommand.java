package FrontController.command;

import FrontController.resource.ConfigurationManager;
import FrontController.logic.LoginLogic;
import FrontController.resource.MessageManager;
import datalayer.DAOFactory;
import datalayer.DBType;
import datalayer.DBTypeException;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        DAOFactory factory = null;
        try {
            factory = DAOFactory.getInstance(DBType.ORACLE);
        } catch (DBTypeException e) {
            e.printStackTrace();
        } finally {
            factory.closeConnection();
        }

        if (LoginLogic.checkAdminLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.admin.welcome");
        } else if (LoginLogic.checkModeratorLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.moderator.welcome");
        } else if (LoginLogic.checkDriverLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.driver.welcome");
        } else if (LoginLogic.checkStorekeeperLogin(login, pass)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.storekeeper.welcome");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
