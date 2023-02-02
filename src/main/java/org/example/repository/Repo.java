package org.example.repository;

import java.util.List;

public interface Repo<T> {

    T save( T t);


    List<T> findAll();
}
