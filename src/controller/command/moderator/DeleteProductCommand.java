package controller.command.moderator;

import controller.command.ActionCommand;
import datalayer.daointerface.ProductDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteProductCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        int identifier = Integer.parseInt(request.getParameter("identifier"));
        ProductDAO productDAO = (ProductDAO) httpSession.getAttribute("ProductDAO");
        productDAO.deleteProduct(identifier);
        page = new ProductListCommand().execute(request);
        return page;
    }
}
