package web.components;

import web.dao.AuthorDAO;
import web.dao.DAO;
import web.entities.Author;
import web.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements DAO<Book> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AuthorDAO<Author> authorDAO;
    private DataSource dataSource;

    public BookDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.authorDAO = new AuthorDAOImpl(dataSource);
    }

    private void updateRelations(int bookId, int authorId) throws SQLException {

        String sql = "insert into Books_Authors(bookId, authorId) values ( ?, ? )";

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

            if (author.getId() == null)
                authorDAO.save(author);
            updateRelations(book.getId(), author.getId());
        }
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
            preparedStatement.execute();

            setRelations(obj);

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public int delete(Book obj) throws SQLException {

        int res = 0;
        String sql = "delete from Books where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, obj.getId());
            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }

        return res;
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
        }

        return (listOfBooks.size() == 0) ? null : listOfBooks;
    }
}