package com.toy.toyboard.service;

import com.toy.toyboard.aggregate.logic.BoardMenuLogic;
import com.toy.toyboard.aggregate.store.jpastore.dto.board.BoardMenuDetail;
import com.toy.toyboard.entity.board.BoardMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("boardMenus")
public class BoardMenuResources {
    //
    private final BoardMenuLogic boardMenuLogic;

    @PostMapping
    public BoardMenu registerBoardMenu(@RequestBody BoardMenu boardMenu) {
        //
        return boardMenuLogic.register(boardMenu);
    }

    @GetMapping
    public List<BoardMenu> findAllBoardMenus() {
        //
        return boardMenuLogic.findAll();
    }

    @GetMapping("/byId/{id}")
    public BoardMenuDetail findById(@PathVariable String id) {
        //
        return boardMenuLogic.findById(id);
    }

    @PutMapping("/{id}")
    public BoardMenu modify(@PathVariable String id, @RequestBody BoardMenu boardMenu) {
        //
        return boardMenuLogic.modify(boardMenu);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        //
        boardMenuLogic.remove(id);
    }
}
