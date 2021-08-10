package repository.base;

import Entity.base.BaseEntity;
import java.util.List;


public interface BaseRepository<E extends BaseEntity<Id>, Id> {
    E save(E e); //insert

    E update(E e);

    List<E> findAll();

    void deleteById(Id id);

    E findById(Id id);

    Boolean existById(Id id);
}
