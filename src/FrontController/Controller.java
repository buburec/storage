package FrontController;

import FrontController.command.ActionCommand;
import FrontController.command.factory.ActionFactory;
import FrontController.resource.ConfigurationManager;
import FrontController.resource.MessageManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        // ����������� �������, ��������� �� JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        /*
         * ����� �������������� ������ execute() � �������� ����������
         * ������-����������� ���������� �������
         */
        page = command.execute(request);
        // ����� ���������� �������� ������
        // page = null; // ��������������������!
        if (page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
            // ����� �������� ������ �� ������
            dispatcher.forward(request, response);
        } else {
            // ��������� �������� c c��������� �� ������
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
