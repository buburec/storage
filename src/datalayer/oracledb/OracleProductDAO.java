package datalayer.oracledb;

import datalayer.daointerface.ProductDAO;
import datalayer.data.Product;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleProductDAO implements ProductDAO {
    private final Connection connection;
    public OracleProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getProductTitleList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.product_identifier_list");
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

    @Override
    public List<Product> getProductList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.moderator.product_list");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<Product> productList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    productList.add(new Product(identifier, title, description, price));
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

    @Override
    public void createProduct(String title, String description, float price) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.moderator.product");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setFloat(3, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
