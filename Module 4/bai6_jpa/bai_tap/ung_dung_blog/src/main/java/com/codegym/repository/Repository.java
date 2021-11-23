package com.codegym.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(int id);

    void add(T model);

    void update(T model);

    void remove(int id);
}
