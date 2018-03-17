package ir.marjan.model.repository;

import java.util.List;

public interface GenericRepository<E> {
    void insert(E e);

    void update(E e);

    void delete(E e);

    void delete(long id);

    E select(long id);

    List<E> select();
}
