package com.toy.toyboard.aggregate.store;

import com.toy.toyboard.entity.board.BoardMenu;

import java.util.List;

public interface BoardMenuStore {
    //
    BoardMenu create(BoardMenu boardMenu);

    BoardMenu update(BoardMenu boardMenu);

    List<BoardMenu> retrieveAll();

    BoardMenu retrieveById(String id);

    void delete(String id);
}
