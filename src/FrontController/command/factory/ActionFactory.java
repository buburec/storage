package FrontController.command.factory;

import FrontController.resource.MessageManager;
import FrontController.command.ActionCommand;
import FrontController.command.EmptyCommand;
import FrontController.command.client.CommandEnum;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // ���������� ����� ������� �� �������
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // ���� ������� �� ������ � ������� �������
            return current;
        }
        // ��������� �������, ���������������� �������
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
