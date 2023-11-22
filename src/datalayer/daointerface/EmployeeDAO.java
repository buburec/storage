package datalayer.daointerface;

import datalayer.data.LoginData;
import datalayer.data.ProfileData;
import datalayer.data.User;

import java.util.List;

public interface EmployeeDAO {
    List<LoginData> getLoginData(String identifier, String password);
    List<ProfileData> getProfile(String identifier);
    void createUser(String identifier, String password, String fullName, int occupationIdentifier);
    void deleteUser(String identifier);
    void updateProfile(String password, String fullName, String identifier);
    void updateStatus(String status, String identifier);
    List<User> getUserList();
}
