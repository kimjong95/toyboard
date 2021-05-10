package com.toy.toyboard.aggregate.logic;

import com.toy.toyboard.aggregate.store.BoardMenuStore;
import com.toy.toyboard.aggregate.store.BoardStore;
import com.toy.toyboard.aggregate.store.UserStore;
import com.toy.toyboard.aggregate.store.jpastore.dto.board.BoardDetail;
import com.toy.toyboard.entity.board.Board;
import com.toy.toyboard.entity.shared.IdName;
import com.toy.toyboard.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardLogic {
    //
    private final BoardStore boardStore;
    private final BoardMenuStore boardMenuStore;
    private final UserStore userStore;

    public Board register(Board board) {
        //
        return boardStore.create(board);
    }

    public Board modify(Board board) {
        //
        return boardStore.update(board);
    }

    public List<Board> findAll() {
        //
        return boardStore.retrieveAll();
    }

    public BoardDetail findById(String id) {
        //
        Board board = boardStore.retrieveById(id);
        User creatorUser = userStore.retrieveById(board.getCreator());
        return new BoardDetail(board, new IdName(creatorUser.getId(), creatorUser.getName()));
    }

    public List<Board> findByIds(List<String> ids) {
        //
        return boardStore.retrieveByIds(ids);
    }

    public List<Board> findByBoardMenuId(String boardMenuId) {
        //
        return boardStore.retrieveByBoardMenuId(boardMenuId);
    }

    public void remove(String id) {
        //
        boardStore.delete(id);
    }
}
