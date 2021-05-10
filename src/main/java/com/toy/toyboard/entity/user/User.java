package com.toy.toyboard.entity.user;

import com.google.gson.Gson;
import com.toy.toyboard.shared.JsonUtil;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;

    private String name;
    private String password;
    private String nickname;
    private Role role;
    private long createTime;

    public User(String id) {
        this.id = id;
    }

    public static User sample() {
        //
        return new User("000001", "홍길동", "passw@rd", "조선최강검", Role.MEMBER, 0);
    }

    public static void main(String[] args) {
        //
        System.out.println(JsonUtil.toJson(User.sample()));
    }
}
