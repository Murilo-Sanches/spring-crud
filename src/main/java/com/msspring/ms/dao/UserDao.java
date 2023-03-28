package com.msspring.ms.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.msspring.ms.model.User;

public interface UserDao {
    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAll();

    Optional<User> selectPersonById(UUID id);

    int updateUserById(UUID id, User user);

    int deleteUserById(UUID id);

}
