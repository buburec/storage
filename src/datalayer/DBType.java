package datalayer;

import datalayer.oracledb.OracleDBDAOFactory;

import javax.naming.NamingException;
import java.sql.SQLException;

public enum DBType {
    ORACLE {
        @Override
        public DAOFactory getDAOFactory() {
            OracleDBDAOFactory oracleDBDAOFactory = null;
            try {
                oracleDBDAOFactory = OracleDBDAOFactory.getInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
            return oracleDBDAOFactory;
        }
    };

    public static DBType getTypeByName(String dbType) {
        try {
            return DBType.valueOf(dbType.toUpperCase());
        } catch (Exception e) {
            throw new DBTypeException();
        }
    }

    public abstract DAOFactory getDAOFactory();

}
