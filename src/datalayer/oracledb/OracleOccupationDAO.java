package datalayer.oracledb;

import datalayer.daointerface.OccupationDAO;
import datalayer.data.OccupationData;
import datalayer.resource.SqlQueriesManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleOccupationDAO implements OccupationDAO {
    private static final String SQL_QUERY = SqlQueriesManager.getProperty("sql.query.select.occupation");
    private final Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public OracleOccupationDAO(Connection connection) {
        this.connection = connection;
    }

    private void setStatement() {
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setResultSet() {
        try {
            this.resultSet = this.statement.executeQuery(OracleOccupationDAO.SQL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<OccupationData> parseResultSet() {
        List<OccupationData> occupationDataList = new ArrayList<>();
        try {
            while (this.resultSet.next()) {
                int identifier = this.resultSet.getInt(1);
                String title = this.resultSet.getString(2);
                String description = this.resultSet.getString(3);
                occupationDataList.add(new OccupationData(identifier, title, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return occupationDataList;
    }

    private void closeStatement() {
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeResultSet() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<OccupationData> getOccupationData() {
        this.setStatement();
        this.setResultSet();
        List<OccupationData> occupationDataList = this.parseResultSet();
        this.closeResultSet();
        this.closeStatement();
        return occupationDataList;
    }
}
