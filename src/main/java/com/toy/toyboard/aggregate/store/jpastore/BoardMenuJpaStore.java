package com.toy.toyboard.aggregate.store.jpastore;

import com.toy.toyboard.aggregate.store.BoardMenuStore;
import com.toy.toyboard.aggregate.store.jpastore.jpo.board.BoardMenuJpo;
import com.toy.toyboard.aggregate.store.jpastore.repository.BoardMenuRepository;
import com.toy.toyboard.entity.board.BoardMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardMenuJpaStore implements BoardMenuStore {
    //
    private final BoardMenuRepository boardMenuRepository;

    @Override
    public BoardMenu create(BoardMenu boardMenu) {
        BoardMenuJpo boardMenuJpo = new BoardMenuJpo(boardMenu);
        boardMenuJpo.setCreateTime(System.currentTimeMillis());
        boardMenuRepository.save(boardMenuJpo);
        return boardMenuJpo.toDomain();
    }

    @Override
    public BoardMenu update(BoardMenu boardMenu) {
        BoardMenuJpo boardMenuJpo = new BoardMenuJpo(boardMenu);
        boardMenuJpo.setUpdatedTime(System.currentTimeMillis());
        boardMenuRepository.save(boardMenuJpo);
        return boardMenuJpo.toDomain();    }

    @Override
    public List<BoardMenu> retrieveAll() {
        return boardMenuRepository.findAll().stream().map(BoardMenuJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public BoardMenu retrieveById(String id) {
        Optional<BoardMenuJpo> boardMenuJpoOptional = boardMenuRepository.findById(id);
        return boardMenuJpoOptional.map(BoardMenuJpo::toDomain).orElse(null);
    }

    @Override
    public void delete(String id) {
        if(boardMenuRepository.existsById(id)) {
            boardMenuRepository.deleteById(id);
        }
    }
}
