package ir.marjan.model.service;

import ir.marjan.model.entity.User;

import java.util.List;

public interface GenericService<E> {
    void save(E e) ;
    void edit(E e);
    void remove(E e) ;

    void remove(long id);
    E find(long id);
    List<E> findAll() ;
}
