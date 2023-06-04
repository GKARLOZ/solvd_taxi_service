package com.solvd.taxiservice.db.dao;

public interface IDAO<T>{

    void create(T t);
    T getById(int id);
    void update(T t);
    void delete(T t);
}
