package com.patika.hw4.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<T> {
    List<T> findAll();
    void deleteById(Long id);
    T update(T object);
}
