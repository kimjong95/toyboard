package com.toy.toyboard.aggregate.store.jpastore.jpo.shared;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class DomainEntityJpo {
    //
    @Id
    protected String id;

    @Version
    protected long entityVersion;

    protected DomainEntityJpo(String id) {
        this.id = id;
        this.entityVersion = 0L;
    }

    public String getId() {
        return this.id;
    }

    public long getEntityVersion() {
        return this.entityVersion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityVersion(long entityVersion) {
        this.entityVersion = entityVersion;
    }

    public DomainEntityJpo() {
    }
}
