package com.solvd.taxiservice.db.service.interfaces;

public interface IService<T> {
    void create(T t);
    T getById(long id);
    void update(T t);
    void delete(T t);

}
