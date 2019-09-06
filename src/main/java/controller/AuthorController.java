package controller;

import components.AuthorDAOImpl;
import connect.ConnectionToDB;
import dao.DAO;
import entities.Author;
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
@RequestMapping("authors")
public class AuthorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private DAO<Author> authorDAO = new AuthorDAOImpl(new ConnectionToDB());

    public AuthorController() {
        logger.info("Author controller created...");
    }

    @ResponseBody
    @RequestMapping()
    public String getAll() throws SQLException {

        logger.info("Method getAll()");

        List<Author> list = authorDAO.getAll();
        if (list == null) return "DB is empty!";

        StringBuilder sb = new StringBuilder();
        for (Author author : list)
            sb.append(author.toString()).append("\n");

        return sb.toString();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public String find(@PathVariable("id") int id) throws SQLException {

        logger.info("Method find()");

        Author author = authorDAO.findById(id);

        if (author != null) return author.toString();
        return "Author is not found!";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String save(String name, String surname) throws SQLException {

        logger.info("Method save()");

        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);

        authorDAO.save(author);
        return "Author saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(String name, String surname, @PathVariable("id") int id) throws SQLException {

        logger.info("Method update()");

        Author author = new Author(id, name, surname);
        authorDAO.update(author);

        return "Author updated!";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) throws SQLException {

        logger.info("Method delete()");

        Author author = new Author();
        author.setId(id);

        if (authorDAO.delete(author) > 0) return "Author deleted!";
        return "Author is not found!";
    }
}
