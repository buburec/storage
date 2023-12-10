package controller.command;

import controller.logic.DAOLogic;
import controller.logic.LoginLogicEnum;
import controller.resource.ConfigurationManager;
import datalayer.DAOFactory;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        DAOFactory factory = DAOLogic.getFactory();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EmployeeDAO employeeDAO = factory.getEmployeeDAO();
        List<Login> loginList = employeeDAO.getLoginData(login, password);
        if (LoginLogicEnum.isLoginRight(loginList)) {
            String occupationTitle = loginList.get(0).getOccupation();
            HttpSession httpSession = request.getSession();
            LoginLogicEnum loginLogicEnum = LoginLogicEnum.valueOf(occupationTitle.toUpperCase());
            page = loginLogicEnum.getRoleAttributes(loginList, httpSession, factory);
        } else {
            String wrongLogin = "Wrong login or/and password!";
            request.setAttribute("wrongLogin", wrongLogin);
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
