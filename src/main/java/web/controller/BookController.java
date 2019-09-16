package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import web.components.BookDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.DAO;
import web.entities.Book;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private DAO<Book> bookDao = new BookDAOImpl(new ConnectionToDB());

    public BookController() {
        logger.info("Book controller created...");
    }

    @ResponseBody
    @RequestMapping()
    public ModelAndView getAll() throws SQLException {

        logger.info("Method getAll()");

        List<Book> list = bookDao.getAll();
        return new ModelAndView("book/books", "books", list);
    }

    @ResponseBody
    @RequestMapping("/details/{id}")
    public ModelAndView details(@PathVariable int id) throws SQLException {

        logger.info("Method details()");

        Book book = bookDao.findById(id);
        return new ModelAndView("book/details", "book", book);
    }

    @ResponseBody
    @RequestMapping("/create")
    public ModelAndView create() throws SQLException {

        logger.info("Method create()");
        return new ModelAndView("book/create", "book", new Book());
    }

    @ResponseBody
    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") int id) throws SQLException {

        logger.info("Method update()");

        Book book = bookDao.findById(id);
        return new ModelAndView("book/update", "book", book);
    }
}