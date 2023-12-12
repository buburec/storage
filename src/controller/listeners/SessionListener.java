package controller.listeners;

import datalayer.daointerface.EmployeeDAO;
import datalayer.data.Profile;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        List<Profile> profile = employeeDAO.getProfile(identifier);
        if (!profile.isEmpty()) {
            String status = profile.get(0).getStatus();
            employeeDAO.updateStatus(status.equals("blocked") ? status : "offline", identifier);
        }
    }
}

