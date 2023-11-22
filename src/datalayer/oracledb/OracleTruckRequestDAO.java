package datalayer.oracledb;

import datalayer.daointerface.TruckRequestDAO;
import datalayer.data.Request;
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
    public List<Request> getDriverRequestList(String host_identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.driver.request_list");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, host_identifier);
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
}
