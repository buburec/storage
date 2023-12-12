package controller;

import controller.command.ActionCommand;
import controller.command.factory.ActionFactory;
import controller.resource.ConfigurationManager;
import controller.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The FrontController class is responsible for processing incoming HTTP requests,
 * determining the appropriate command, and dispatching the request to the corresponding
 * command for further processing.
 */
public class FrontController extends HttpServlet {

    /**
     * Processes HTTP GET requests by invoking the common processRequest method.
     *
     * @param request  the HttpServletRequest object that contains the request the client has made
     * @param response the HttpServletResponse object that contains the response the servlet sends to the client
     * @throws ServletException if an exception occurs that interferes with the servlet's normal operation
     * @throws IOException      if an input or output exception occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String page = ConfigurationManager.getProperty("path.page.index");
//        request.getSession().setAttribute("nullPage",
//                MessageManager.getProperty("message.nullpage"));
//        response.sendRedirect(request.getContextPath() + page);
        processRequest(request, response);
    }

    /**
     * Processes HTTP POST requests by invoking the common processRequest method.
     *
     * @param request  the HttpServletRequest object that contains the request the client has made
     * @param response the HttpServletResponse object that contains the response the servlet sends to the client
     * @throws ServletException if an exception occurs that interferes with the servlet's normal operation
     * @throws IOException      if an input or output exception occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes the incoming HTTP request, determines the appropriate action command,
     * and forwards the request to the corresponding command for execution.
     *
     * @param request  the HttpServletRequest object that contains the request the client has made
     * @param response the HttpServletResponse object that contains the response the servlet sends to the client
     * @throws ServletException if an exception occurs that interferes with the servlet's normal operation
     * @throws IOException      if an input or output exception occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
