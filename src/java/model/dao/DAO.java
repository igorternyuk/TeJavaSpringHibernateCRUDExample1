package model.dao;

import java.util.List;

/**
 *
 * @author igor
 */
public interface DAO<T> {
    boolean create(T obj);
    boolean update(T obj);
    boolean remove(Object key);
    T getById(Object id);
    List<T> readAll();
}
