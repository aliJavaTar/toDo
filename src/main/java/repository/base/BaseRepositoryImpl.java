package repository.base;

import Entity.base.BaseEntity;


import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<Id>, Id> implements BaseRepository<E, Id> {

    private EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
