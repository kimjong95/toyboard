package com.toy.toyboard.aggregate.logic;

import com.toy.toyboard.aggregate.store.BoardMenuStore;
import com.toy.toyboard.aggregate.store.BoardStore;
import com.toy.toyboard.aggregate.store.UserStore;
import com.toy.toyboard.aggregate.store.jpastore.dto.board.BoardMenuDetail;
import com.toy.toyboard.entity.board.BoardMenu;
import com.toy.toyboard.entity.shared.IdName;
import com.toy.toyboard.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardMenuLogic {
    //
    private final BoardMenuStore boardMenuStore;
    private final UserStore userStore;

    public BoardMenu register(BoardMenu boardMenu) {
        //
        return boardMenuStore.create(boardMenu);
    }

    public BoardMenu modify(BoardMenu boardMenu) {
        //
        return boardMenuStore.update(boardMenu);
    }

    public List<BoardMenu> findAll() {
        //
        return boardMenuStore.retrieveAll();
    }

    public BoardMenuDetail findById(String id) {
        //
        BoardMenu boardMenu = boardMenuStore.retrieveById(id);
        User creatorUser = userStore.retrieveById(boardMenu.getCreator());
        return new BoardMenuDetail(boardMenu, new IdName(creatorUser.getId(), creatorUser.getName()));
    }

    public void remove(String id) {
        //
        boardMenuStore.delete(id);
    }
}
