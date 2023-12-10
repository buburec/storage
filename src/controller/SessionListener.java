package controller;

import datalayer.daointerface.EmployeeDAO;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession httpSession = se.getSession();
        String identifier = (String) httpSession.getAttribute("identifier");
        EmployeeDAO employeeDAO = (EmployeeDAO) httpSession.getAttribute("EmployeeDAO");
        String status = employeeDAO.getProfile(identifier).get(0).getStatus();
        employeeDAO.updateStatus(status.equals("blocked") ? status : "offline", identifier);
    }
}

