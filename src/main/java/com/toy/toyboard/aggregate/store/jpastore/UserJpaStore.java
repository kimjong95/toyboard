package com.toy.toyboard.aggregate.store.jpastore;

import com.toy.toyboard.aggregate.store.UserStore;
import com.toy.toyboard.aggregate.store.jpastore.jpo.UserJpo;
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
        System.out.println(user.getId());
        System.out.println(user.getName());
        userRepository.save(userJpo);
        return userJpo.toDomain();
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> retrieve() {
        return userRepository.findAll().stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public User retrieveById(String id) {
        Optional<UserJpo> userJpoOptional = userRepository.findById(id);
        if(!userJpoOptional.isPresent()) {
            return null;
        }
        return userJpoOptional.get().toDomain();
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
