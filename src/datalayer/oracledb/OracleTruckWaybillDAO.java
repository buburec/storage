package datalayer.oracledb;

import datalayer.daointerface.TruckWaybillDAO;
import datalayer.data.Waybill;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTruckWaybillDAO implements TruckWaybillDAO {
    private final Connection connection;
    public OracleTruckWaybillDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Waybill> getTruckWaybill() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.truck_waybill");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<Waybill> waybillList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    int quantity = resultSet.getInt(3);
                    waybillList.add(new Waybill(identifier, title, quantity));
                }
                return waybillList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Waybill> getTruckWaybill(int identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.id_truck_waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Waybill> waybillList = new ArrayList<>();
                while (resultSet.next()) {
                    int productIdentifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    int quantity = resultSet.getInt(3);
                    waybillList.add(new Waybill(productIdentifier, title, quantity));
                }
                return waybillList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addWaybillProduct(String title, int quantity) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.driver.waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updateWaybillProduct(String title, int quantity) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.driver.waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, title);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void updateCurrentWaybill(String truckIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.driver.current_waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, truckIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLastAcceptedWaybill(int identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.driver.last_accepted_waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, identifier);
            preparedStatement.setInt(2, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWaybillProduct(int productIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.driver.waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, productIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTruckWaybill(int identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.storekeeper.waybill");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
