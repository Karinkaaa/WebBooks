package dao;

import exception.DAOException;

import java.util.List;

public interface DAO<T> {

    void save(T book) throws DAOException;

    void update(T book) throws DAOException;

    int delete(T book) throws DAOException;

    T findById(long id) throws DAOException;

    List<T> getAll() throws DAOException;
}
