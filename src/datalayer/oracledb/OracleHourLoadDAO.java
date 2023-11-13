//package datalayer.oracledb;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class OracleHourLoadDAO implements HourLoadDAO {
//    private Connection connection;
//    private Statement statement;
//    private ResultSet resultSet;
//
//    public OracleHourLoadDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    private void setStatement() {
//        try {
//            this.statement = this.connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void setResultSet(String sqlQuery) {
//        try {
//            this.resultSet = this.statement.executeQuery(sqlQuery);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private LecturerHourLoadArray parseResultSet() {
//        LecturerHourLoadArray lecturerHourLoadArray = new LecturerHourLoadArray();
//        try {
//            while (this.resultSet.next()) {
//                String surname = this.resultSet.getString(ColumnIndexer.FIRST_COLUMN);
//                String name = this.resultSet.getString(ColumnIndexer.SECOND_COLUMN);
//                String patronymic = this.resultSet.getString(ColumnIndexer.THIRD_COLUMN);
//                int hoursLoad = this.resultSet.getInt(ColumnIndexer.FOURTH_COLUMN);
//                lecturerHourLoadArray.addLecturer(new LecturerHourLoad(surname, name, patronymic, hoursLoad));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lecturerHourLoadArray;
//    }
//
//    private void closeStatement() {
//        if (this.statement != null) {
//            try {
//                this.statement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void closeResultSet() {
//        if (this.resultSet != null) {
//            try {
//                this.resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public LecturerHourLoadArray getLecturerHourLoadArray(String sqlQuery) {
//        this.setStatement();
//        this.setResultSet(sqlQuery);
//        LecturerHourLoadArray lecturerHourLoadArray = this.parseResultSet();
//        this.closeResultSet();
//        this.closeStatement();
//        return lecturerHourLoadArray;
//    }
//
//}
