package com.toy.toyboard.aggregate.store.jpastore;

import com.toy.toyboard.aggregate.store.BoardStore;
import com.toy.toyboard.aggregate.store.jpastore.jpo.board.BoardJpo;
import com.toy.toyboard.aggregate.store.jpastore.repository.BoardRepository;
import com.toy.toyboard.entity.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardJpaStore implements BoardStore {
    //
    private final BoardRepository boardRepository;

    @Override
    public Board create(Board board) {
        BoardJpo boardJpo = new BoardJpo(board);
        boardJpo.setCreateTime(System.currentTimeMillis());
        boardRepository.save(boardJpo);
        return boardJpo.toDomain();
    }

    @Override
    public Board update(Board board) {
        BoardJpo boardJpo = new BoardJpo(board);
        boardJpo.setUpdatedTime(System.currentTimeMillis());
        boardRepository.save(boardJpo);
        return boardJpo.toDomain();
    }

    @Override
    public List<Board> retrieveAll() {
        return boardRepository.findAll().stream().map(BoardJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public Board retrieveById(String id) {
        Optional<BoardJpo> boardJpoOptional = boardRepository.findById(id);
        return boardJpoOptional.map(BoardJpo::toDomain).orElse(null);
    }

    @Override
    public List<Board> retrieveByIds(List<String> ids) {
        return boardRepository.findAllById(ids).stream().map(BoardJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Board> retrieveByBoardMenuId(String boardMenuId) {
        return boardRepository.findByBoardMenuId(boardMenuId);
    }

    @Override
    public void delete(String id) {
        if(boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
        }
    }
}
