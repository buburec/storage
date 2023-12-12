package datalayer.oracledb;

import datalayer.daointerface.EmployeeDAO;
import datalayer.data.Login;
import datalayer.data.Profile;
import datalayer.data.User;
import datalayer.resource.SqlQueriesManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The OracleEmployeeDAO class provides an implementation of the EmployeeDAO interface
 * for Oracle database. It includes methods to retrieve login data, user profiles, create users,
 * delete users, update user profiles, update user status, and get a list of users.
 */
public class OracleEmployeeDAO implements EmployeeDAO {
    private final Connection connection;

    /**
     * Constructs a new OracleEmployeeDAO with the specified database connection.
     *
     * @param connection the database connection
     */
    public OracleEmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves login data for a given identifier and password.
     *
     * @param identifier the user identifier
     * @param password   the user password
     * @return a list of Login objects containing login information
     */
    @Override
    public List<Login> getLoginData(String identifier, String password) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.login_data");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Login> loginList = new ArrayList<>();
                while (resultSet.next()) {
                    identifier = resultSet.getString(1);
                    password = resultSet.getString(2);
                    String occupation = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    loginList.add(new Login(identifier, password, occupation, status));
                }
                return loginList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves user profiles for a given identifier.
     *
     * @param identifier the user identifier
     * @return a list of Profile objects containing user profiles
     */
    @Override
    public List<Profile> getProfile(String identifier) {
        String sqlQuery = SqlQueriesManager.getProperty("sql.query.select.profile");
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, identifier);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Profile> profileList = new ArrayList<>();
                while (resultSet.next()) {
                    identifier = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    String fullName = resultSet.getString(3);
                    String title = resultSet.getString(4);
                    String status = resultSet.getString(5);
                    profileList.add(new Profile(identifier, password, fullName, title, status));
                }
                return profileList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a new user with the specified information.
     *
     * @param identifier           the user identifier
     * @param password             the user password
     * @param fullName             the user's full name
     * @param occupationIdentifier the identifier of the user's occupation
     */
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

    /**
     * Deletes a user with the specified identifier.
     *
     * @param identifier the user identifier
     */
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

    /**
     * Updates the profile of a user with the specified information.
     *
     * @param password   the user password
     * @param fullName   the user's full name
     * @param identifier the user identifier
     */
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

    /**
     * Updates the status of a user with the specified information.
     *
     * @param status     the user status
     * @param identifier the user identifier
     */
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

    /**
     * Retrieves a list of users.
     *
     * @return a list of User objects containing user information
     */
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
