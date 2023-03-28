package com.msspring.ms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.msspring.ms.model.User;

@Repository("fakeDao")
public class FakePersonDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName()));
        return 0;
    }

    @Override
    public List<User> selectAll() {
        return DB;
    }

    @Override
    public Optional<User> selectPersonById(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int updateUserById(UUID id, User update) {
        return selectPersonById(id).map(user -> {
            int indexToUpdate = DB.indexOf(user);

            if (indexToUpdate >= 0) {
                DB.set(indexToUpdate, new User(id, update.getName()));
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);

    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> user = selectPersonById(id);

        if (user.isEmpty()) {
            return 0;
        }

        DB.remove(user.get());
        return 1;
    }

}
