package datalayer.oracledb;

import datalayer.daointerface.TruckMovementDAO;
import datalayer.data.StorageTruckProduct;
import datalayer.data.TruckIdentifier;
import datalayer.resource.SqlQueriesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleTruckMovementDAO implements TruckMovementDAO {
    private final Connection connection;

    public OracleTruckMovementDAO(Connection connection) {
        this.connection = connection;
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
    public List<TruckIdentifier> getInsideTruckIdentifierList(String host_identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.inside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, host_identifier);
            preparedStatement.setString(2, host_identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<TruckIdentifier> truckIdentifierList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    truckIdentifierList.add(new TruckIdentifier(truckIdentifier));
                }
                return truckIdentifierList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TruckIdentifier> getOutsideTruckIdentifierList(String host_identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.outside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, host_identifier);
            preparedStatement.setString(2, host_identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<TruckIdentifier> truckIdentifierList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    truckIdentifierList.add(new TruckIdentifier(truckIdentifier));
                }
                return truckIdentifierList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
