package datalayer.oracledb;

import datalayer.daointerface.StorageProductDAO;
import datalayer.data.Product;
import datalayer.data.StorageProduct;
import datalayer.data.Waybill;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleStorageProductDAO implements StorageProductDAO {
    private final Connection connection;
    public OracleStorageProductDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<StorageProduct> getDriverStorageProductList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.storage_product_list");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<StorageProduct> storageProductList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    int quantity = resultSet.getInt(4);
                    storageProductList.add(new StorageProduct(identifier, title, description, quantity));
                }
                return storageProductList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProductTitleList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.storage_product_identifier_list");
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
    public List<Waybill> getAcceptLoadingProductList(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.storekeeper.accept_loading");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Waybill> storageProductList = new ArrayList<>();
                while (resultSet.next()) {
                    int productIdentifier = resultSet.getInt(1);
                    int quantity = resultSet.getInt(2);
                    storageProductList.add(new Waybill(productIdentifier, quantity));
                }
                return storageProductList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Waybill> getAcceptUnloadingProductList(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.storekeeper.accept_unloading");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Waybill> storageProductList = new ArrayList<>();
                while (resultSet.next()) {
                    int productIdentifier = resultSet.getInt(1);
                    int quantity = resultSet.getInt(2);
                    storageProductList.add(new Waybill(productIdentifier, quantity));
                }
                return storageProductList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteStorageProductList(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.storekeeper.storage_product");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertStorageProductList(Waybill waybill) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.storekeeper.storage_product");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, waybill.getProductIdentifier());
            preparedStatement.setInt(2, waybill.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Waybill> getMaxStorageProductList(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.storekeeper.max_storage_product");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Waybill> storageProductList = new ArrayList<>();
                while (resultSet.next()) {
                    int productIdentifier = resultSet.getInt(1);
                    int quantity = resultSet.getInt(2);
                    storageProductList.add(new Waybill(productIdentifier, quantity));
                }
                return storageProductList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
