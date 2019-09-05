package components;

import dao.AuthorDAO;
import entities.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO<Author> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private DataSource dataSource;

    public AuthorDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
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
        }

        return listOfAuthors;
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
        }
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

        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public int delete(Author obj) throws SQLException {

        int res = 0;
        String sql = "delete from Authors where id = ?";

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
        }

        return listOfAuthors;
    }
}