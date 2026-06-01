package org.example.preprj311.service;

import org.example.preprj311.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUserById(long id);

    void updateUser(User userUpdated) ;

    void removeUserById(long id);

    List<User> getAllUsers();
}
