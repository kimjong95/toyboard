package com.toy.toyboard.entity.user;

import com.google.gson.Gson;
import com.toy.toyboard.entity.shared.DomainEntity;
import com.toy.toyboard.shared.JsonUtil;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User extends DomainEntity {
    //
    private String name;
    private String password;
    private String nickname;
    private Role role;
    private long createTime;
    private long updatedTime;

    public User(String id) {
        super(id);
    }

    public User(String id, String password, String nickname, Role role) {
        super(id);
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public static User sample() {
        //
        return new User( "홍길동", "passw@rd", "조선최강검", Role.MEMBER);
    }

    public static void main(String[] args) {
        //
        System.out.println(JsonUtil.toJson(User.sample()));
    }
}
