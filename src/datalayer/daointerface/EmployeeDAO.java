package datalayer.daointerface;

import datalayer.data.Login;
import datalayer.data.Profile;
import datalayer.data.User;

import java.util.List;

public interface EmployeeDAO {
    List<Login> getLoginData(String identifier, String password);
    List<Profile> getProfile(String identifier);
    void createUser(String identifier, String password, String fullName, int occupationIdentifier);
    void deleteUser(String identifier);
    void updateProfile(String password, String fullName, String identifier);
    void updateStatus(String status, String identifier);
    List<User> getUserList();
}
