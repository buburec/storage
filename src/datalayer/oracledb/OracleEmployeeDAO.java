package datalayer.oracledb;

import datalayer.daointerface.EmployeeDAO;
import datalayer.data.LoginData;
import datalayer.data.ProfileData;
import datalayer.data.User;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleEmployeeDAO implements EmployeeDAO {
    private final Connection connection;
    public OracleEmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<LoginData> getLoginData(String identifier, String password) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.login_data");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<LoginData> loginDataList = new ArrayList<>();
                while (resultSet.next()) {
                    identifier = resultSet.getString(1);
                    password = resultSet.getString(2);
                    String occupation = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    loginDataList.add(new LoginData(identifier, password, occupation, status));
                }
                return loginDataList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProfileData> getProfile(String identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.profile");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<ProfileData> profileDataList = new ArrayList<>();
                while (resultSet.next()) {
                    identifier = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    String fullName = resultSet.getString(3);
                    String title = resultSet.getString(4);
                    String status = resultSet.getString(5);
                    profileDataList.add(new ProfileData(identifier, password, fullName, title, status));
                }
                return profileDataList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createUser(String identifier, String password, String fullName, int occupationIdentifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.insert.user");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, fullName);
            preparedStatement.setInt(4, occupationIdentifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.delete.user");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(String password, String fullName, String identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.profile");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(String status, String identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.update.status");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, identifier);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUserList() {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.user_list");
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                List<User> userList = new ArrayList<>();
                while (resultSet.next()) {
                    String identifier = resultSet.getString(1);
                    String fullName = resultSet.getString(2);
                    String title = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    userList.add(new User(identifier, fullName, title, status));
                }
                return userList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
