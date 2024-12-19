package io.codeforall.fanstatics.Daos.Interfaces;

import io.codeforall.fanstatics.Models.Interfaces.Model;

import java.util.List;

public interface Dao <T extends Model> {

    List<T> findAll();

    T findById(Integer id);


    T saveOrUpdate(T modelObject);


    void delete(Integer id);
}
