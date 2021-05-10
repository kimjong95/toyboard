package com.toy.toyboard.entity.board;

import com.toy.toyboard.entity.shared.DomainEntity;
import com.toy.toyboard.entity.shared.IdName;
import com.toy.toyboard.shared.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board extends DomainEntity {
    //
    private String name;
    private String creator;
    private long createTime;
    private long updatedTime;
    private String boardMenuId;

    public Board(String id) {
        //
        super(id);
    }

    public Board(String id, String creator, String boardMenuId) {
        //
        super(id);
        this.creator = creator;
        this.boardMenuId = boardMenuId;
    }

    public static Board sample() {
        return new Board("id", "creatorId", "boardMenuId");
    }

    public static void main(String[] args) {
        //
        System.out.println(JsonUtil.toJson(Board.sample()));
    }
}
