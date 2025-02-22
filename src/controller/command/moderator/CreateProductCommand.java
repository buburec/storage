package controller.command.moderator;

import controller.command.ActionCommand;
import datalayer.daointerface.ProductDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateProductCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        HttpSession httpSession = request.getSession();
        ProductDAO productDAO = (ProductDAO) httpSession.getAttribute("ProductDAO");
        productDAO.createProduct(title, description, price);
        page = new ProductListCommand().execute(request);
        return page;
    }
}
