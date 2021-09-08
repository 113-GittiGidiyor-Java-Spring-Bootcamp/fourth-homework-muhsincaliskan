package com.patika.hw4.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    void deleteById(Long id);
    T update(T object);
}
