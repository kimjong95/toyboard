package com.toy.toyboard.aggregate.logic;

import com.toy.toyboard.aggregate.store.UserStore;
import com.toy.toyboard.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLogic {
    //
    private final UserStore userStore;

    public User register(User user) {
        //
        return userStore.create(user);
    }

    public User modify(User user) {
        //
        return userStore.update(user);
    }

    public List<User> findAll() {
        //
        return userStore.retrieve();
    }

    public User findById(String id) {
        //
        return userStore.retrieveById(id);
    }

    public List<User> findByIds(List<String> ids) {
        //
        return userStore.retrieveByIds(ids);
    }

    public void remove(String id) {
        //
        userStore.delete(id);
    }
}
