package com.msspring.ms.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.msspring.ms.dao.UserDao;
import com.msspring.ms.model.User;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("fakeDao") UserDao userDao) {
    // public UserService(@Qualifier("mysql") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> getAll() {
        return userDao.selectAll();
    }

    public Optional<User> getPersonById(UUID id) {
        return userDao.selectPersonById(id);
    }

    public int deleteUser(UUID id) {
        return userDao.deleteUserById(id);
    }

    public int updateUser(UUID id, User newUser) {
        return userDao.updateUserById(id, newUser);
    }
}
