package FrontController.logic;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String MODERATOR_LOGIN = "moderator";
    private final static String DRIVER_LOGIN = "driver";
    private final static String STOREKEEPER_LOGIN = "storekeeper";
    private final static String ADMIN_PASS = "1";
    private final static String MODERATOR_PASS = "1";
    private final static String DRIVER_PASS = "1";
    private final static String STOREKEEPER_PASS = "1";

    public static boolean checkAdminLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }

    public static boolean checkModeratorLogin(String enterLogin, String enterPass) {
        return MODERATOR_LOGIN.equals(enterLogin) && MODERATOR_PASS.equals(enterPass);
    }

    public static boolean checkDriverLogin(String enterLogin, String enterPass) {
        return DRIVER_LOGIN.equals(enterLogin) && DRIVER_PASS.equals(enterPass);
    }

    public static boolean checkStorekeeperLogin(String enterLogin, String enterPass) {
        return STOREKEEPER_LOGIN.equals(enterLogin) && STOREKEEPER_PASS.equals(enterPass);
    }
}
