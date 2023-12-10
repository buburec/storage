package controller;

import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckStatusFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession(false);

        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        String identifier = (String) httpSession.getAttribute("identifier");
        String status = employeeDAO != null ? employeeDAO.getProfile(identifier).get(0).getStatus() : null;

        if (identifier == null) {
            String page = ConfigurationManager.getProperty("path.page.login");
            RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(httpRequest, httpResponse);
            return;
        }

        if (status != null && status.equals("blocked")) {
            httpSession.invalidate();
            String page = ConfigurationManager.getProperty("path.page.blocked");
            RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(httpRequest, httpResponse);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра
    }

    @Override
    public void destroy() {
        // Уничтожение фильтра
    }
}
