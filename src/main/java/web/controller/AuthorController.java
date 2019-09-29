package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import web.components.AuthorDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.AuthorDAO;
import web.entities.Author;

import java.sql.SQLException;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final AuthorDAO<Author> authorDAO;

    public AuthorController(AuthorDAO<Author> authorDAO) {
        logger.info("Author controller created...");
        this.authorDAO = authorDAO;
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
        return new ModelAndView("author/create", "author", new Author());
    }

    @ResponseBody
    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) throws SQLException {

        logger.info("Method Author update()");
        return new ModelAndView("author/update", "author", authorDAO.findById(id));
    }

    @ResponseBody
    @RequestMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id) throws SQLException {

        logger.info("Method Author details()");
        return new ModelAndView("author/details", "author", authorDAO.findById(id));
    }

    @ResponseBody
    @RequestMapping("/filter")
    public ModelAndView filter(Integer bookId, String name) throws SQLException {

        if (bookId == null) bookId = 0;
        if (name == null) name = "";
        logger.info("Method Author filter()");
        return new ModelAndView("author/search", "authors", authorDAO.filter(bookId, name));
    }
}
