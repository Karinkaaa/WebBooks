package web.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.components.AuthorDAOImpl;
import web.components.BookDAOImpl;
import web.connect.ConnectionToDB;
import web.dao.DAO;
import web.entities.Author;
import web.entities.Book;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookAPIController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final DAO<Book> bookDao;
    private final DAO<Author> authorDAO;

    public BookAPIController(DAO<Book> bookDao, DAO<Author> authorDAO) {
        logger.info("Book API controller created...");
        this.bookDao = bookDao;
        this.authorDAO = authorDAO;
    }

    @ResponseBody
    @RequestMapping()
    public List<Book> getAll() throws SQLException {

        logger.info("Method Book API getAll()");
        return bookDao.getAll();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Book find(@PathVariable("id") int id) throws SQLException {

        logger.info("Method Book API find()");
        return bookDao.findById(id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Book save(String name) throws SQLException {

        logger.info("Method Book API save()");

        Book book = new Book();
        book.setName(name);
        bookDao.save(book);
        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Book update(String name, @PathVariable("id") int id) throws SQLException {

        logger.info("Method Book API update()");
        logger.info("Name: " + name + "\nID: " + id);

        Book book = new Book(id, name);
        bookDao.update(book);
        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Book delete(@PathVariable("id") int id) throws SQLException {

        logger.info("Method Book API delete()");

        Book book = new Book();
        book.setId(id);

        bookDao.delete(book);
        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/{aid}", method = RequestMethod.DELETE)
    public Book deleteAuthor(@PathVariable("id") int id, @PathVariable("aid") int aid) throws SQLException {

        logger.info("Method Book API deleteAuthor()");

        Book book = bookDao.findById(id);
        Author author = authorDAO.findById(aid);

        book.removeAuthor(author);
        bookDao.update(book);

        return book;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/{aid}", method = RequestMethod.POST)
    public Book addAuthor(@PathVariable("id") int bookId, @PathVariable("aid") int authorId) throws SQLException {

        logger.info("Method Book API addAuthor()");

        Author author = authorDAO.findById(authorId);
        Book book = bookDao.findById(bookId);

        book.addAuthor(author);
        bookDao.update(book);

        return book;
    }
}