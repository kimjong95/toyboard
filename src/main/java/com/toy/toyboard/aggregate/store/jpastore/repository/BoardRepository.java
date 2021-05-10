package com.toy.toyboard.aggregate.store.jpastore.repository;

import com.toy.toyboard.aggregate.store.jpastore.jpo.board.BoardJpo;
import com.toy.toyboard.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardJpo, String> {
    //
    List<Board> findByBoardMenuId(String boardMenuId);
}
