package web.controller.api;

import web.components.AuthorDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.DAO;
import web.entities.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api/authors")
public class AuthorAPIController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private DAO<Author> authorDAO = new AuthorDAOImpl(new ConnectionToDB());

    public AuthorAPIController() {
        logger.info("Author API controller created...");
    }

    @ResponseBody
    @RequestMapping()
    public List<Author> getAll() throws SQLException {

        logger.info("Method Author API getAll()");
        return authorDAO.getAll();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Author find(@PathVariable("id") int id) throws SQLException {

        logger.info("Method Author API find()");
        return authorDAO.findById(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Author save(String name, String surname) throws SQLException {

        logger.info("Method Author API save()");

        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);

        authorDAO.save(author);
        return author;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Author update(String name, String surname, @PathVariable("id") int id) throws SQLException {

        logger.info("Method Author API update()");

        Author author = new Author(id, name, surname);
        authorDAO.update(author);
        return author;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Author delete(@PathVariable("id") int id) throws SQLException {

        logger.info("Method Author API delete()");

        Author author = new Author();
        author.setId(id);

        authorDAO.delete(author);
        return author;
    }
}
