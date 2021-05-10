package com.toy.toyboard.aggregate.store;

import com.toy.toyboard.entity.board.Board;

import java.util.List;

public interface BoardStore {
    //
    Board create(Board board);

    Board update(Board board);

    List<Board> retrieveAll();

    Board retrieveById(String id);

    List<Board> retrieveByIds(List<String> ids);

    List<Board> retrieveByBoardMenuId(String boardMenuId);

    void delete(String id);
}
