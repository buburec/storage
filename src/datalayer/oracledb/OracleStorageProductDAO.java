package datalayer.oracledb;

import datalayer.daointerface.StorageProductDAO;
import datalayer.data.StorageProduct;
import datalayer.resource.SqlQueriesManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleStorageProductDAO implements StorageProductDAO {
    private static final String SQL_QUERY = SqlQueriesManager.getProperty("sql.query.select.driver.storage_product_list");
    private final Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public OracleStorageProductDAO(Connection connection) {
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
            this.resultSet = this.statement.executeQuery(OracleStorageProductDAO.SQL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<StorageProduct> parseResultSet() {
        List<StorageProduct> storageProductList = new ArrayList<>();
        try {
            while (this.resultSet.next()) {
                int identifier = this.resultSet.getInt(1);
                String title = this.resultSet.getString(2);
                String description = this.resultSet.getString(3);
                int quantity = this.resultSet.getInt(4);
                storageProductList.add(new StorageProduct(identifier, title, description, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storageProductList;
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
    public List<StorageProduct> getDriverStorageProductList() {
        this.setStatement();
        this.setResultSet();
        List<StorageProduct> storageProductList = this.parseResultSet();
        this.closeResultSet();
        this.closeStatement();
        return storageProductList;
    }
}
