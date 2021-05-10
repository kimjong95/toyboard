package com.toy.toyboard.aggregate.store;

import com.toy.toyboard.entity.user.User;

import java.util.List;

public interface UserStore {
    //
    User create(User user);

    User update(User user);

    List<User> retrieve();

    User retrieveById(String id);

    List<User> retrieveByIds(List<String> ids);

    void delete(String id);
}
