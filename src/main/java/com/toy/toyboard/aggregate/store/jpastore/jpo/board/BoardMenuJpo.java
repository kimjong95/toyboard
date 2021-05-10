package com.toy.toyboard.aggregate.store.jpastore.jpo.board;

import com.toy.toyboard.aggregate.store.jpastore.jpo.shared.DomainEntityJpo;
import com.toy.toyboard.entity.board.Board;
import com.toy.toyboard.entity.board.BoardMenu;
import com.toy.toyboard.entity.shared.IdName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "BOARD_MENU")
public class BoardMenuJpo extends DomainEntityJpo {
    //
    private String name;
    private String creator;
    private long createTime;
    private long updatedTime;

    public BoardMenuJpo(BoardMenu boardMenu) {
        super(boardMenu.getId());
        this.creator = boardMenu.getCreator();
        this.createTime = boardMenu.getCreateTime();
        this.updatedTime = boardMenu.getUpdatedTime();
    }

    public BoardMenu toDomain() {
        //
        BoardMenu boardMenu = new BoardMenu(this.getId());
        boardMenu.setCreator(this.creator);
        boardMenu.setName(this.getName());
        boardMenu.setCreateTime(this.getCreateTime());
        boardMenu.setUpdatedTime(this.getUpdatedTime());
        return boardMenu;
    }
}
