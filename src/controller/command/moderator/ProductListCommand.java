package controller.command.moderator;

import controller.command.ActionCommand;
import controller.resource.ConfigurationManager;
import datalayer.daointerface.ProductDAO;
import datalayer.data.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ProductListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession httpSession = request.getSession();
        ProductDAO productDAO = (ProductDAO) httpSession.getAttribute("ProductDAO");
        List<Product> usedProductList = productDAO.getUsedProductList();
        request.setAttribute("usedProductList", usedProductList);
        List<Product> unusedProductList = productDAO.getUnusedProductList();
        request.setAttribute("unusedProductList", unusedProductList);
        page = ConfigurationManager.getProperty("path.page.moderator.product_list");
        return page;
    }
}
