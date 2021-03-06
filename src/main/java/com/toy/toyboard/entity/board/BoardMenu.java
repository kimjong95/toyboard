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
public class BoardMenu extends DomainEntity {
    //
    private String name;
    private String creator;
    private long createTime;
    private long updatedTime;

    public BoardMenu(String id) {
        super(id);
    }

    public BoardMenu(String id, String name, String idName) {
        super(id);
        this.name = name;
        this.creator = idName;
    }

    public static BoardMenu sample() {
        //
        return new BoardMenu("id", "name", "CreatorId");
    }

    public static void main(String[] args) {
        //
        System.out.println(JsonUtil.toJson(BoardMenu.sample()));
    }
}
