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

/**
 * The OracleOccupationDAO class provides an implementation of the OccupationDAO interface
 * for Oracle database. It includes a method to retrieve occupation data.
 */
public class OracleOccupationDAO implements OccupationDAO {
    private final Connection connection;

    /**
     * Constructs a new OracleOccupationDAO with the specified database connection.
     *
     * @param connection the database connection
     */
    public OracleOccupationDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves occupation data from the database.
     *
     * @return a list of Occupation objects containing occupation information
     */
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
