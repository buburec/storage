package datalayer.oracledb;

import datalayer.daointerface.ProductDAO;
import datalayer.data.Product;
import datalayer.resource.SqlQueriesManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleProductDAO implements ProductDAO {
    private final Connection connection;
    public OracleProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getProductTitleList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.product_list");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<Product> productList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    productList.add(new Product(identifier, title));
                }
                return productList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
