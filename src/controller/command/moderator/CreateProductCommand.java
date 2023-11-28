package controller.command.moderator;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.ProductDAO;
import datalayer.data.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        List<Product> productList = productDAO.getProductList();
        request.setAttribute("productList", productList);
        page = ConfigurationManager.getProperty("path.page.moderator.product_list");
        return page;
    }
}
