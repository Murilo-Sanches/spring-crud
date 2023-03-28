package com.msspring.ms.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.msspring.ms.model.User;

@Repository("mysql")
public class UserDataAccessService implements UserDao {

    @Override
    public int insertUser(UUID id, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertUser'");
    }

    @Override
    public List<User> selectAll() {
        return List.of(new User(UUID.randomUUID(), "From MySQL"));
    }

    @Override
    public Optional<User> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectPersonById'");
    }

    @Override
    public int updateUserById(UUID id, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserById'");
    }

    @Override
    public int deleteUserById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

}
