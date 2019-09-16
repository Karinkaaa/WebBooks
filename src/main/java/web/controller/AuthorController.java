package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import web.components.AuthorDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.DAO;
import web.entities.Author;

import java.sql.SQLException;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private DAO<Author> authorDAO = new AuthorDAOImpl(new ConnectionToDB());

    public AuthorController() {
        logger.info("Author controller created...");
    }

    @ResponseBody
    @RequestMapping()
    public ModelAndView getAll() throws SQLException {

        logger.info("Method Author getAll()");
        return new ModelAndView("author/authors", "authors", authorDAO.getAll());
    }

    @ResponseBody
    @RequestMapping("/create")
    public ModelAndView create() throws SQLException {

        logger.info("Method Author create()");
        return new ModelAndView("book/create", "author", new Author());
    }

    @ResponseBody
    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) throws SQLException {

        logger.info("Method update()");
        return new ModelAndView("book/update", "author", authorDAO.findById(id));
    }
}
