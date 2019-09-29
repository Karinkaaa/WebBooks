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
public class AuthorDAOImpl implements AuthorDAO<Author> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private DAO<Book> bookDAO;
    private DataSource dataSource;

    @Autowired
    public AuthorDAOImpl(DAO<Book> bookDAO, DataSource dataSource) {
        this.bookDAO = bookDAO;
        this.dataSource = dataSource;
    }

    private void removeRelations(Author author) throws SQLException {

        String sql;
        List<Book> books = author.getBooks();

        if (books.size() == 0) {
            sql = "delete from Books_Authors where authorId = ?";

        } else {
            sql = "delete from Books_Authors where authorId = ? and bookId not in (";

            for (int i = 0; i < books.size(); i++) {

                if (i < books.size() - 1)
                    sql += "?, ";
                else
                    sql += "?)";
            }
        }

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, author.getId());

            for (int i = 0; i < books.size(); i++) {
                preparedStatement.setInt(i + 2, books.get(i).getId());
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

    private void setRelations(Author author) throws SQLException {

        List<Book> books = author.getBooks();

        for (Book book : books) {

            if (book.getId() > 0)
                bookDAO.save(book);

            updateRelations(book.getId(), author.getId());
        }
        removeRelations(author);
    }


    @Override
    public void update(Author obj) throws SQLException {

        String sql = "update Authors set name = ?, surname = ? where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getSurname());
            preparedStatement.setInt(3, obj.getId());
            preparedStatement.execute();

            setRelations(obj);

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<Author> findByBookId(int id) throws SQLException {

        List<Author> listOfAuthors = new ArrayList<>();
        String sql = "select * from Authors where Authors.id in " +
                "(select authorId from Books_Authors where bookId = ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"));
                listOfAuthors.add(author);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

        return listOfAuthors;
    }

    @Override
    public List<Author> filter(int bookId, String name) throws SQLException {

        List<Author> resultList = new ArrayList<>();
        String sql = "select * from Authors where (Authors.name like ? or surname like ?) " +
                "and Authors.id not in (select authorId from Books_Authors where bookId = ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            name = ("%" + name + "%");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, bookId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"));
                resultList.add(author);
            }
        }
        return resultList;
    }

    @Override
    public void save(Author obj) throws SQLException {

        String sql = "insert into Authors(id, name, surname) values ( ?, ?, ? )";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getSurname());
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    obj.setId(generatedKeys.getInt(1));
                else
                    throw new SQLException("Cannot generate id!");
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public Author delete(Author obj) throws SQLException {

        String sql = "delete from Authors where id = ?";

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
    public Author findById(long id) throws SQLException {

        Author author = null;
        String sql = "select * from Authors where id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if (resultSet.next()) {
                author = new Author(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"));
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

        return author;
    }

    @Override
    public List<Author> getAll() throws SQLException {

        List<Author> listOfAuthors = new ArrayList<>();
        String sql = "select * from Authors";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Author author = new Author(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"));
                listOfAuthors.add(author);
            }

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }

        return listOfAuthors;
    }
}