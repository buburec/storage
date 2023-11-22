package datalayer.oracledb;

import datalayer.DAOFactory;
import datalayer.daointerface.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance()
            throws ClassNotFoundException, SQLException, NamingException {
        OracleDBDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDBDAOFactory.class) {
                instance = factory = new OracleDBDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException, NamingException {
        Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
        DataSource ds = (DataSource) envCtx.lookup("jdbc/database");
        connection = ds.getConnection();
        System.out.println("Connected to oracle DB!");
    }

    @Override
    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new OracleEmployeeDAO(connection);
    }

    @Override
    public OccupationDAO getOccupationDAO() {
        return new OracleOccupationDAO(connection);
    }

    @Override
    public TruckRequestDAO getTruckRequestDAO() {
        return new OracleTruckRequestDAO(connection);
    }

    @Override
    public StorageProductDAO getStorageProductDAO() {
        return new OracleStorageProductDAO(connection);
    }

    @Override
    public TruckMovementDAO getTruckMovementDAO() {
        return new OracleTruckMovementDAO(connection);
    }

    @Override
    public TruckDAO getTruckDAO() {
        return null;
    }

    @Override
    public ProductDAO getProductDAO() {
        return new OracleProductDAO(connection);
    }
}
