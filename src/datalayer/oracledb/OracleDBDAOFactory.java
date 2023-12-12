package datalayer.oracledb;

import datalayer.DAOFactory;
import datalayer.daointerface.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * The OracleDBDAOFactory class represents a concrete implementation of the DAOFactory interface
 * for the Oracle database. It provides methods to obtain various Data Access Objects (DAOs)
 * for different entities such as Employee, Occupation, TruckRequest, StorageProduct, Truck,
 * Product, and TruckWaybill.
 */
public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;

    private OracleDBDAOFactory() {
    }

    /**
     * Gets the singleton instance of OracleDBDAOFactory.
     *
     * @return the singleton instance of OracleDBDAOFactory
     * @throws ClassNotFoundException if the class is not found
     * @throws SQLException           if a SQL exception occurs
     * @throws NamingException        if a naming exception occurs
     */
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

    /**
     * Opens the database connection
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NamingException
     */
    private void connected() throws ClassNotFoundException, SQLException, NamingException {
        Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
        DataSource ds = (DataSource) envCtx.lookup("jdbc/database");
        connection = ds.getConnection();
        System.out.println("Connected to Oracle DB!");
    }

    /**
     * Closes the database connection.
     */
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

    /**
     * Gets the EmployeeDAO for Oracle database.
     *
     * @return the EmployeeDAO for Oracle database
     */
    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new OracleEmployeeDAO(connection);
    }

    /**
     * Gets the OccupationDAO for Oracle database.
     *
     * @return the OccupationDAO for Oracle database
     */
    @Override
    public OccupationDAO getOccupationDAO() {
        return new OracleOccupationDAO(connection);
    }

    /**
     * Gets the TruckRequestDAO for Oracle database.
     *
     * @return the TruckRequestDAO for Oracle database
     */
    @Override
    public TruckRequestDAO getTruckRequestDAO() {
        return new OracleTruckRequestDAO(connection);
    }

    /**
     * Gets the StorageProductDAO for Oracle database.
     *
     * @return the StorageProductDAO for Oracle database
     */
    @Override
    public StorageProductDAO getStorageProductDAO() {
        return new OracleStorageProductDAO(connection);
    }

    /**
     * Gets the TruckDAO for Oracle database.
     *
     * @return the TruckDAO for Oracle database
     */
    @Override
    public TruckDAO getTruckDAO() {
        return new OracleTruckDAO(connection);
    }

    /**
     * Gets the ProductDAO for Oracle database.
     *
     * @return the ProductDAO for Oracle database
     */
    @Override
    public ProductDAO getProductDAO() {
        return new OracleProductDAO(connection);
    }

    /**
     * Gets the TruckWaybillDAO for Oracle database.
     *
     * @return the TruckWaybillDAO for Oracle database
     */
    @Override
    public TruckWaybillDAO getTruckWaybillDAO() {
        return new OracleTruckWaybillDAO(connection);
    }
}
