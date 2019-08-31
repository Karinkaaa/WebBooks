package db.dao;

import db.entity.Book;

import java.util.List;

public interface IBookDAO {

    void save(Book book) throws DAOException;

    void update(Book book) throws DAOException;

    int delete(Book book) throws DAOException;

    Book findById(long id) throws DAOException;

    List<Book> getAll() throws DAOException;
}
