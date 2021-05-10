package com.toy.toyboard.entity.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DomainEntity {
    //
    private String id;

    public DomainEntity(String id) {
        this.id = id;
    }

    public DomainEntity() {

    }
}
