package controller.command;

import controller.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        /* � ������ ������ ��� ������� ��������� � �����������
         * ������������� �� �������� ����� ������ */
        System.out.println("EmptyCommand happened");
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
