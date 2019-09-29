package web.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.AuthorDAO;
import web.dao.DAO;
import web.entities.Author;
import web.entities.Book;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAOImpl implements DAO<Book> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AuthorDAO<Author> authorDAO;
    private DataSource dataSource;

    @Autowired
    public BookDAOImpl(AuthorDAO<Author> authorDAO, DataSource dataSource) {
        this.authorDAO = authorDAO;
        this.dataSource = dataSource;
    }

    private void removeRelations(Book book) throws SQLException {

        String sql;
        List<Author> authors = book.getAuthors();

        if (authors.size() == 0) {
            sql = "delete from Books_Authors where authorId = ?";

        } else {
            sql = "delete from Books_Authors where authorId = ? and bookId not in (";

            for (int i = 0; i < authors.size(); i++) {

                if (i < authors.size() - 1)
                    sql += "?, ";
                else
                    sql += "?)";
            }
        }

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, book.getId());

            for (int i = 0; i < authors.size(); i++) {
                preparedStatement.setInt(i + 2, authors.get(i).getId());
            }
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    private void updateRelations(int bookId, int authorId) throws SQLException {

        String sql = "insert ignore into Books_Authors(bookId, authorId) values ( ?, ? )";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, authorId);
            preparedStatement.execute();

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    private void setRelations(Book book) throws SQLException {

        List<Author> authors = book.getAuthors();

        for (Author author : authors) {

            if (author.getId() > 0)
                authorDAO.save(author);

            updateRelations(book.getId(), author.getId());
        }
        removeRelations(book);
    }

    @Override
    public void save(Book obj) throws SQLException {

        String sql = "insert into Books(id, name) values ( ?, ? )";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    obj.setId(generatedKeys.getInt(1));
                else
                    throw new SQLException("Cannot generate id!");
            }
            setRelations(obj);

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public void update(Book obj) throws SQLException {

        String sql = "update Books set name = ? where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getId());
            preparedStatement.executeUpdate();

            setRelations(obj);

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Book delete(Book obj) throws SQLException {

        String sql = "delete from Books where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, obj.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
        return obj;
    }

    @Override
    public Book findById(long id) throws SQLException {

        Book book = null;
        String sql = "select * from Books where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                book = new Book(resultSet.getInt("id"), resultSet.getString("name"));
                book.setAuthors(authorDAO.findByBookId(book.getId()));
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

        return book;
    }

    @Override
    public List<Book> getAll() throws SQLException {

        List<Book> listOfBooks = new ArrayList<>();
        String sql = "select * from Books";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("name"));
                book.setAuthors(authorDAO.findByBookId(book.getId()));
                listOfBooks.add(book);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

        return (listOfBooks.size() == 0) ? null : listOfBooks;
    }
}