package hib.repository;

import hib.entities.User;

import java.util.List;


public interface UserDAO {
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
}
