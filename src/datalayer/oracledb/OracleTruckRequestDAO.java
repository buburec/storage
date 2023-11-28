package datalayer.oracledb;

import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Request;
import datalayer.data.StorageTruckProduct;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTruckRequestDAO implements TruckRequestDAO {
    private final Connection connection;
    public OracleTruckRequestDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Request> getDriverRequestList(String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.request_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, hostIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Request> driverRequestList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String truckModel = resultSet.getString(2);
                    String topic = resultSet.getString(3);
                    Date sentDate = resultSet.getDate(4);
                    String resolver = resultSet.getString(5);
                    String status = resultSet.getString(6);
                    driverRequestList.add(new Request(identifier, truckModel, topic, sentDate, resolver, status));
                }
                return driverRequestList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Request> getStorekeeperRequestList(String resolverIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.storekeeper.request_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, resolverIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Request> storekeeperRequestList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String truckModel = resultSet.getString(2);
                    String topic = resultSet.getString(3);
                    Date sentDate = resultSet.getDate(4);
                    String resolver = resultSet.getString(5);
                    String status = resultSet.getString(6);
                    storekeeperRequestList.add(new Request(identifier, truckModel, topic, sentDate, resolver, status));
                }
                return storekeeperRequestList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StorageTruckProduct> getStorageTruckProductList(String host_identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.storage_truck_product_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, host_identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<StorageTruckProduct> storageTruckProductList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    int quantity = resultSet.getInt(4);
                    storageTruckProductList.add(new StorageTruckProduct(truckIdentifier, title, description, quantity));
                }
                return storageTruckProductList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Request> getRequest(int identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.request");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Request> requestList = new ArrayList<>();
                while (resultSet.next()) {
                    identifier = resultSet.getInt(1);
                    String truckIdentifier = resultSet.getString(2);
                    String commentary = resultSet.getString(3);
                    String topic = resultSet.getString(4);
                    String status = resultSet.getString(5);
                    String resolverResponse = resultSet.getString(6);
                    String resolver = resultSet.getString(7);
                    requestList.add(new Request(identifier, truckIdentifier, commentary, topic, status, resolverResponse, resolver));
                }
                return requestList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createTruckRequest(String actionType, Date sentDate) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.driver.truck_request");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, actionType);
            preparedStatement.setDate(2, sentDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTruckRequest(String truckIdentifier, String commentary) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.driver.truck_request");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, truckIdentifier);
            preparedStatement.setString(2, commentary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTruckRequest() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.driver.truck_request");
        try (Statement statement = this.connection.createStatement()) {
            statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTruckRequest(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.driver.id_truck_request");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTruckRequestList(int requestIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.storekeeper.truck_request");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, requestIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTruckRequestStatus(int requestIdentifier, String status) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.storekeeper.request_status");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, requestIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateResolverResponse(int requestIdentifier, String resolverResponse) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.storekeeper.resolver_response");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, resolverResponse);
            preparedStatement.setInt(2, requestIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
