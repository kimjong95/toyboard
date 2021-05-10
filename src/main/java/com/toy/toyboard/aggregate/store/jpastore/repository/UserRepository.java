package com.toy.toyboard.aggregate.store.jpastore.repository;

import com.toy.toyboard.aggregate.store.jpastore.jpo.user.UserJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpo, String> {
}
