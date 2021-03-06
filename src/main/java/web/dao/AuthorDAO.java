package web.dao;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDAO<T> extends DAO<T> {

    List<T> findByBookId(int id) throws SQLException;
    List<T> filter(int bookId, String name) throws SQLException;
}
