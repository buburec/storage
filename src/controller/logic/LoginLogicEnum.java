package controller.logic;

import controller.resource.ConfigurationManager;
import datalayer.DAOFactory;
import datalayer.data.Login;

import javax.servlet.http.HttpSession;
import java.util.List;

public enum LoginLogicEnum {
    ADMINISTRATOR {
        @Override
        public String getRoleAttributes(List<Login> loginList, HttpSession httpSession, DAOFactory factory) {
            if (LoginLogicEnum.isUserBlocked(loginList)) {
                return ConfigurationManager.getProperty("path.page.blocked");
            }
            httpSession.setAttribute("identifier", loginList.get(0).getIdentifier());
            LoginLogicEnum.setStatus("online", loginList.get(0).getIdentifier(), factory);
            DAOLogic.setAdministratorDAO(httpSession, factory);
            return ConfigurationManager.getProperty("path.page.admin.welcome");
        }
    },
    MODERATOR {
        @Override
        public String getRoleAttributes(List<Login> loginList, HttpSession httpSession, DAOFactory factory) {
            if (LoginLogicEnum.isUserBlocked(loginList)) {
                return ConfigurationManager.getProperty("path.page.blocked");
            }
            httpSession.setAttribute("identifier", loginList.get(0).getIdentifier());
            LoginLogicEnum.setStatus("online", loginList.get(0).getIdentifier(), factory);
            DAOLogic.setModeratorDAO(httpSession, factory);
            return ConfigurationManager.getProperty("path.page.moderator.welcome");
        }
    },
    DRIVER {
        @Override
        public String getRoleAttributes(List<Login> loginList, HttpSession httpSession, DAOFactory factory) {
            if (LoginLogicEnum.isUserBlocked(loginList)) {
                return ConfigurationManager.getProperty("path.page.blocked");
            }
            httpSession.setAttribute("identifier", loginList.get(0).getIdentifier());
            LoginLogicEnum.setStatus("online", loginList.get(0).getIdentifier(), factory);
            DAOLogic.setDriverDAO(httpSession, factory);
            return ConfigurationManager.getProperty("path.page.driver.welcome");
        }
    },
    STOREKEEPER {
        @Override
        public String getRoleAttributes(List<Login> loginList, HttpSession httpSession, DAOFactory factory) {
            if (LoginLogicEnum.isUserBlocked(loginList)) {
                return ConfigurationManager.getProperty("path.page.blocked");
            }
            httpSession.setAttribute("identifier", loginList.get(0).getIdentifier());
            LoginLogicEnum.setStatus("online", loginList.get(0).getIdentifier(), factory);
            DAOLogic.setStorekeeperDAO(httpSession, factory);
            return ConfigurationManager.getProperty("path.page.storekeeper.welcome");
        }
    };

    public abstract String getRoleAttributes(List<Login> loginList, HttpSession httpSession, DAOFactory factory);

    private static boolean isUserBlocked(List<Login> loginList) {
        return loginList.get(0).getStatus().equals("blocked");
    }

    private static void setStatus(String status, String identifier, DAOFactory factory) {
        factory.getEmployeeDAO().updateStatus(status, identifier);
    }

    public static boolean isLoginRight(List<Login> loginList) {
        return !(loginList.isEmpty());
    }
}
