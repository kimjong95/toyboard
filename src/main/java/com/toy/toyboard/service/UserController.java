package com.toy.toyboard.service;

import com.toy.toyboard.aggregate.logic.UserLogic;
import com.toy.toyboard.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    //
    private final UserLogic userLogic;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        //
        return userLogic.register(user);
    }

    @GetMapping
    public List<User> findAllUsers() {
        //
        return userLogic.findAll();
    }

    @GetMapping("/byId/{id}")
    public User findUserById(@PathVariable String id) {
        //
        return userLogic.findById(id);
    }

    @GetMapping("/byIds/{ids}")
    public List<User> findUserByIds(@PathVariable List<String> ids) {
        //
        return userLogic.findByIds(ids);
    }

    @PutMapping("/{id}")
    public User modify(@PathVariable String id, @RequestBody User user) {
        //
        return userLogic.modify(user);
    }

    @DeleteMapping("{/id}")
    public void remove(@PathVariable String id) {
        //
        userLogic.remove(id);
    }
}
