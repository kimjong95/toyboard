package com.toy.toyboard.aggregate.store.jpastore.jpo;

import com.toy.toyboard.entity.user.Role;
import com.toy.toyboard.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserJpo {
    //
    @Id
    protected String id;
    @Version
    protected long entityVersion;

    private String name;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;
    private long createTime;

    public UserJpo(User user) {
        //
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.createTime = user.getCreateTime();
    }

    public User toDomain() {
        //
        User user = new User(getId());
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setNickname(this.getNickname());
        user.setRole(this.getRole());
        user.setCreateTime(this.getCreateTime());
        return user;
    }
}
