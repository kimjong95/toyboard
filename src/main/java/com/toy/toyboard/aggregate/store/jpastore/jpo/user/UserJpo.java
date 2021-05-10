package com.toy.toyboard.aggregate.store.jpastore.jpo.user;

import com.toy.toyboard.aggregate.store.jpastore.jpo.shared.DomainEntityJpo;
import com.toy.toyboard.entity.user.Role;
import com.toy.toyboard.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "USER")
public class UserJpo extends DomainEntityJpo {
    //
    private String name;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;
    private long createTime;
    private long updatedTime;

    public UserJpo(User user) {
        //
        super(user.getId());
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
