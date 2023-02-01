package org.example.repository;

import org.example.dto.Bill;

import java.util.List;

public interface Repo<T> {

    T save( T t);

    T findById( Number id);

    List<T> findAll();
}
