package controller;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        // String page = "/index.jsp";
        String page = ConfigurationManager.getProperty("path.page.index");
        // ����������� ������
        request.getSession().invalidate();
        return page;
    }
}
