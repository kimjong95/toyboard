package com.toy.toyboard.aggregate.store.jpastore.repository;

import com.toy.toyboard.aggregate.store.jpastore.jpo.board.BoardMenuJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardMenuRepository extends JpaRepository<BoardMenuJpo, String> {
}
