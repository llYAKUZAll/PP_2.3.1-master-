package web.dao;

import web.model.User;

import java.util.*;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);
}