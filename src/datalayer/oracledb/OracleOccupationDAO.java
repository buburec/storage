package datalayer.oracledb;

import datalayer.daointerface.OccupationDAO;
import datalayer.data.Occupation;
import datalayer.resource.SqlQueriesManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleOccupationDAO implements OccupationDAO {
    private final Connection connection;

    public OracleOccupationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Occupation> getOccupationData() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.occupation");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<Occupation> occupationList = new ArrayList<>();
                while (resultSet.next()) {
                    int identifier = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    occupationList.add(new Occupation(identifier, title, description));
                }
                return occupationList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
