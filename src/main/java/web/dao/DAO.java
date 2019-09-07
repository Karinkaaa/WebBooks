package web.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    void save(T obj) throws SQLException;

    void update(T obj) throws SQLException;

    int delete(T obj) throws SQLException;

    T findById(long id) throws SQLException;

    List<T> getAll() throws SQLException;
}
