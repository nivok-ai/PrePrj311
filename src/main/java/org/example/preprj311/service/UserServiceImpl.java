package org.example.preprj311.service;

import org.example.preprj311.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.preprj311.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userDao) {
        this.userRepository = userDao;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.getReferenceById(id);
    }

    public void updateUser(User userUpdated) {
        userRepository.save(userUpdated);
    }

    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

