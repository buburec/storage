package datalayer.oracledb;

import datalayer.DAOFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

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

//    @Override
//    public LecturerListDAO getGroupLecturersDAO() {
//        return new OracleLecturerListDAO(connection);
//    }
//
//    @Override
//    public HourLoadDAO getHourLoadDAO() {
//        return new OracleHourLoadDAO(connection);
//    }
//
//    @Override
//    public PeriodLoadDAO getPeriodLoadDAO() {
//        return new OraclePeriodLoadDAO(connection);
//    }
}
