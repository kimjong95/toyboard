package com.toy.toyboard.aggregate.store.jpastore;

import com.toy.toyboard.aggregate.store.UserStore;
import com.toy.toyboard.aggregate.store.jpastore.jpo.user.UserJpo;
import com.toy.toyboard.aggregate.store.jpastore.repository.UserRepository;
import com.toy.toyboard.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserJpaStore implements UserStore {
    //
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        UserJpo userJpo = new UserJpo(user);
        userJpo.setCreateTime(System.currentTimeMillis());
        userRepository.save(userJpo);
        return userJpo.toDomain();
    }

    @Override
    public User update(User user) {
        UserJpo userJpo = new UserJpo(user);
        userJpo.setUpdatedTime(System.currentTimeMillis());
        userRepository.save(userJpo);
        return userJpo.toDomain();
    }

    @Override
    public List<User> retrieve() {
        return userRepository.findAll().stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public User retrieveById(String id) {
        Optional<UserJpo> userJpoOptional = userRepository.findById(id);
        return userJpoOptional.map(UserJpo::toDomain).orElse(null);
    }

    @Override
    public List<User> retrieveByIds(List<String> ids) {
        return userRepository.findAllById(ids).stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
