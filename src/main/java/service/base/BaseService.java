package service.base;

import Entity.base.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity<Id>, Id> {
    E save(E e);

    E update(E e);

    List<E> findAll();

    void deleteById(Id id);

    E findById(Id id);
}
