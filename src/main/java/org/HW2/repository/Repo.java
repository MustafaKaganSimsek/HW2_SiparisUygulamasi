package org.HW2.repository;

import java.util.List;

public interface Repo<T> {

    T save( T t);


    List<T> findAll();
}
