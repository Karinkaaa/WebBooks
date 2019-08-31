package db.dao;

import db.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DataSource dataSource;

    public BookDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Book book) throws DAOException {

        String sql = "insert into Books(name) values ( ? )";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, book.getName());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            logger.info("Book added...");

        } catch (DAOException | SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void update(Book book) throws DAOException {

        String sql = "update Books set name = ? where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, book.getName());
            preparedStatement.setLong(2, book.getId());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            logger.info("Book updated...");

        } catch (DAOException | SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public int delete(Book book) throws DAOException {

        int res = 0;
        String sql = "delete from Books where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, book.getId());
            res = preparedStatement.executeUpdate();

        } catch (DAOException | SQLException ex) {
            logger.error(ex.getMessage());
        }

        return res;
    }

    @Override
    public Book findById(long id) throws DAOException {

        Book book = null;
        String sql = "select * from Books where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                book = new Book(resultSet.getLong("id"), resultSet.getString("name"));
            }

        } catch (DAOException | SQLException ex) {
            logger.error(ex.getMessage());
        }

        return book;
    }

    @Override
    public List<Book> getAll() throws DAOException {

        List<Book> listOfBooks = new ArrayList<>();
        String sql = "select * from Books";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getLong("id"), resultSet.getString("name"));
                listOfBooks.add(book);
            }

        } catch (DAOException | SQLException ex) {
            logger.error(ex.getMessage());
        }

        return (listOfBooks.size() == 0) ? null : listOfBooks;
    }
}