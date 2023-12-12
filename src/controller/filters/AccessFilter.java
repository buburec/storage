package controller.filters;

import controller.resource.ConfigurationManager;
import datalayer.daointerface.EmployeeDAO;
import datalayer.data.Profile;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AccessFilter implements Filter {
    private static final String INACTIVE_MESSAGE = "You were inactive!";
    private static final String LOGGED_OUT_MESSAGE = "You are not logged in!";
    private static final String DELETE_MESSAGE = "You were deleted!";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession(false);

        if (AccessFilter.isSessionDead(httpSession)) {
            AccessFilter.forwardLogin(httpRequest, httpResponse, AccessFilter.INACTIVE_MESSAGE);
            return;
        }

        String identifier = (String) httpSession.getAttribute("identifier");
        if (AccessFilter.isUserLogged(identifier)) {
            AccessFilter.forwardLogin(httpRequest, httpResponse, AccessFilter.LOGGED_OUT_MESSAGE);
            return;
        }

        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        List<Profile> profile = employeeDAO.getProfile(identifier);
        if (AccessFilter.isUserDeleted(profile)) {
            AccessFilter.forwardLogin(httpRequest, httpResponse, AccessFilter.DELETE_MESSAGE);
            return;
        }

        String status = employeeDAO.getProfile(identifier).get(0).getStatus();
        if (AccessFilter.isUserBlocked(status)) {
            AccessFilter.forwardBlock(httpRequest, httpResponse);
            return;
        }

        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        // Уничтожение фильтра
    }

    private static boolean isSessionDead(HttpSession httpSession) {
        return httpSession == null;
    }

    private static boolean isUserLogged(String identifier) {
        return identifier == null;
    }

    private static boolean isUserBlocked(String status) {
        return status.equals("blocked");
    }

    private static boolean isUserDeleted(List<Profile> profile) { return profile.isEmpty(); }

    private static void forwardLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String loginInformation)
            throws ServletException, IOException {
        String page = ConfigurationManager.getProperty("path.page.login");
        httpRequest.setAttribute("loginInformation", loginInformation);
        RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
        dispatcher.forward(httpRequest, httpResponse);
    }

    private static void forwardBlock(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws ServletException, IOException {
        httpRequest.getSession().invalidate();
        String page = ConfigurationManager.getProperty("path.page.blocked");
        RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher(page);
        dispatcher.forward(httpRequest, httpResponse);
    }
}
