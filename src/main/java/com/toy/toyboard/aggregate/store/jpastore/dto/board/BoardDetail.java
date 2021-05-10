package com.toy.toyboard.aggregate.store.jpastore.dto.board;

import com.toy.toyboard.entity.board.Board;
import com.toy.toyboard.entity.shared.IdName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDetail {
    //
    private Board board;
    private IdName creator;
}
