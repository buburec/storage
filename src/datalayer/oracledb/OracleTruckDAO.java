package datalayer.oracledb;

import datalayer.daointerface.TruckDAO;
import datalayer.data.Truck;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTruckDAO implements TruckDAO {
    private Connection connection;

    public OracleTruckDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Truck> getInsideTruckIdentifierList(String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.inside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, hostIdentifier);
            preparedStatement.setString(2, hostIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Truck> truckIdentifierList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    truckIdentifierList.add(new Truck(truckIdentifier));
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
    public List<Truck> getOutsideTruckIdentifierList(String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.outside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, hostIdentifier);
            preparedStatement.setString(2, hostIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Truck> truckIdentifierList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    truckIdentifierList.add(new Truck(truckIdentifier));
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
    public List<Truck> getInsideTruckList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.storekeeper.truck_list");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<Truck> truckList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    String model = resultSet.getString(2);
                    String host = resultSet.getString(3);
                    truckList.add(new Truck(truckIdentifier, model, host));
                }
                return truckList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Truck> getInsideTruckList(String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.inside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, hostIdentifier);
            preparedStatement.setString(2, hostIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Truck> truckList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    String model = resultSet.getString(2);
                    truckList.add(new Truck(truckIdentifier, model));
                }
                return truckList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Truck> getOutsideTruckList(String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.outside_truck_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, hostIdentifier);
            preparedStatement.setString(2, hostIdentifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Truck> truckList = new ArrayList<>();
                while (resultSet.next()) {
                    String truckIdentifier = resultSet.getString(1);
                    String model = resultSet.getString(2);
                    truckList.add(new Truck(truckIdentifier, model));
                }
                return truckList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createTruck(String identifier, String model, String hostIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.driver.truck");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, hostIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
