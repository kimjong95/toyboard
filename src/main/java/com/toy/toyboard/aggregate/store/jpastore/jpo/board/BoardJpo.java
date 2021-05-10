package com.toy.toyboard.aggregate.store.jpastore.jpo.board;

import com.toy.toyboard.aggregate.store.jpastore.jpo.shared.DomainEntityJpo;
import com.toy.toyboard.entity.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "BOARD")
public class BoardJpo extends DomainEntityJpo {
    //
    private String name;
    private String creator;
    private long createTime;
    private long updatedTime;
    private String boardMenuId;

    public BoardJpo(Board board) {
        super(board.getId());
        this.creator = board.getCreator();
        this.createTime = board.getCreateTime();
        this.updatedTime = board.getUpdatedTime();
        this.boardMenuId = board.getBoardMenuId();
    }

    public Board toDomain() {
        //
        Board board = new Board(getId());
        board.setCreateTime(this.getCreateTime());
        board.setUpdatedTime(this.getUpdatedTime());
        board.setBoardMenuId(this.getBoardMenuId());
        return board;
    }
}
