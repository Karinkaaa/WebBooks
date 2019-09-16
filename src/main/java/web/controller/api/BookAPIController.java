package web.controller.api;

import web.components.BookDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.DAO;
import web.entities.Book;
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
@RequestMapping("/api/books")
public class BookAPIController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private DAO<Book> bookDao = new BookDAOImpl(new ConnectionToDB());

    public BookAPIController() {
        logger.info("Book API controller created...");
    }

    @ResponseBody
    @RequestMapping()
    public List<Book> getAll() throws SQLException {

        logger.info("Method getAll()");
        return bookDao.getAll();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Book find(@PathVariable("id") int id) throws SQLException {

        logger.info("Method find()");
        return bookDao.findById(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Book save(String name) throws SQLException {

        logger.info("Method save()");

        Book book = new Book();
        book.setName(name);
        bookDao.save(book);
        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Book update(String name, @PathVariable("id") int id) throws SQLException {

        logger.info("Method update()");
        logger.info("Name: " + name + "\nID: " + id);

        Book book = new Book(id, name);
        bookDao.update(book);
        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Book delete(@PathVariable("id") int id) throws SQLException {

        logger.info("Method delete()");

        Book book = new Book();
        book.setId(id);

        bookDao.delete(book);
        return book;
    }
}