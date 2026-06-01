package org.example.preprj311.service;

//import org.example.preprj311.dao.UserDao;
import org.example.preprj311.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.preprj311.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userDao;

    @Autowired
    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User getUserById(long id) {
        return userDao.getReferenceById(id);
    }

    public void updateUser(User userUpdated) {
        userDao.save(userUpdated);
    }

    public void removeUserById(long id) {
        userDao.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    /*private final org.example.preprj311.dao.UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User userUpdated) {
        userDao.updateUser(userUpdated);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
*/
}

