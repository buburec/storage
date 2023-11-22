package controller.logic;

import datalayer.DAOFactory;
import datalayer.DBType;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.LoginData;

import java.util.List;

public class LoginLogic {
    private static final String BLOCKED_USER = "blocked";
    private static List<LoginData> loginDataList;
    private static final DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
    private static final EmployeeDAO employeeDAO = factory.getEmployeeDAO();

    public static DAOFactory getFactory() {
        return factory;
    }

    public static void setLoginDataList(String enteredLogin, String enteredPassword) {
        LoginLogic.loginDataList = LoginLogic.employeeDAO.getLoginData(enteredLogin, enteredPassword);
    }

    private static boolean isLoginRight() {
        return !(LoginLogic.loginDataList.isEmpty());
    }

    public static String getOccupationTitle() {
        if (LoginLogic.isLoginRight()) {
            return LoginLogic.loginDataList.get(0).getOccupation();
        }
        return null;
    }

    public static boolean isUserBlocked() {
        return loginDataList.get(0).getStatus().equals(LoginLogic.BLOCKED_USER);
    }

    public static void setStatus(String status, String identifier) {
        LoginLogic.employeeDAO.updateStatus(status, identifier);
    }

}
