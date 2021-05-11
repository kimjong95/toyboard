package com.toy.toyboard.service;

import com.toy.toyboard.aggregate.logic.BoardLogic;
import com.toy.toyboard.aggregate.store.jpastore.dto.board.BoardDetail;
import com.toy.toyboard.entity.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("boards")
public class BoardResources {
    //
    private final BoardLogic boardLogic;

    @PostMapping
    public Board register(@RequestBody Board board) {
        //
        return boardLogic.register(board);
    }

    @PutMapping("/{id}")
    public Board modify(@PathVariable String id, @RequestBody Board board) {
        //
        return boardLogic.modify(board);
    }

    @GetMapping
    public List<Board> findAllBoards() {
        //
        return boardLogic.findAll();
    }

    @GetMapping("/byId/{id}")
    public BoardDetail findById(@PathVariable String id) {
        //
        return boardLogic.findById(id);
    }

    @GetMapping("/byIds/{ids}")
    public List<Board> findByIds(@PathVariable List<String> ids) {
        //
        return boardLogic.findByIds(ids);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        //
        boardLogic.remove(id);
    }
}
