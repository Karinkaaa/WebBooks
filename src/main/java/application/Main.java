package application;

import components.BookDAOImpl;
import connect.ConnectionToDB;
import dao.DAO;
import entities.Author;
import entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Logger logger = LoggerFactory.getLogger(Main.class.getName());
        Scanner scanner = new Scanner(System.in);

        DAO<Book> bookDao = new BookDAOImpl(new ConnectionToDB());
        String name, surname;
        int action, id;

        do {
            logger.info("\n\nMenu:");
            logger.info("[1] add book");
            logger.info("[2] show book from id");
            logger.info("[3] show all books");
            logger.info("[4] update book");
            logger.info("[5] delete book from id");
            logger.info("[0] exit");
            logger.info("Enter an action: ");
            action = scanner.nextInt();

            if (action == 1) {

                logger.info("Enter the name of book: ");
                name = scanner.next();

                Book book = new Book();
                book.setName(name);

                logger.info("Enter the count authors of book: ");
                int count = scanner.nextInt();

                for (int i = 0; i < count; i++) {

                    logger.info("Enter the name of " + (i + 1) + "-th author: ");
                    name = scanner.next();

                    logger.info("Enter the surname of " + (i + 1) + "-th author: ");
                    surname = scanner.next();

                    book.setAuthor(new Author(name, surname));
                }

                bookDao.save(book);

            } else if (action == 2) {

                logger.info("Enter the id from book: ");
                id = scanner.nextInt();

                Book book = bookDao.findById(id);

                if (book != null) logger.info(book.toString());
                else logger.info("Book with ID " + id + " not found!");

            } else if (action == 3) {

                List<Book> list = bookDao.getAll();

                if (list != null) {
                    for (Book book : list) {
                        logger.info(book.toString());
                    }
                } else {
                    logger.info("Table is empty...");
                }

            } else if (action == 4) {

                logger.info("Enter the id of book: ");
                id = scanner.nextInt();

                logger.info("Enter the new name for book: ");
                name = scanner.next();

                Book book = new Book(id, name);
                String choice;

                if (book.getAuthors().size() == 0) {

                    logger.info("Do you want to add authors? (y - yes, n - no)");
                    choice = scanner.next();

                    logger.info("How many?");
                    int count = scanner.nextInt();

                    if (choice.equals("y")) {

                        for (int i = 0; i < count; i++) {
                            logger.info("Enter the name of author: ");
                            name = scanner.next();

                            logger.info("Enter the surname of author: ");
                            surname = scanner.next();

                            book.setAuthor(new Author(name, surname));
                        }
                    }
                } else {

                    logger.info("Do you want to change authors? (y - yes, n - no)");
                    choice = scanner.next();

                    if (choice.equals("y")) {

                        for (int i = 0; i < book.getAuthors().size(); i++) {

                            logger.info(book.getAuthorById(i).toString());
                            logger.info("Change this author? (y - yes, n - no)");
                            choice = scanner.next();

                            if (choice.equals("y")) {

                                logger.info("Enter the new name of author: ");
                                name = scanner.next();

                                logger.info("Enter the new surname of author: ");
                                surname = scanner.next();

                                book.setAuthor(new Author(name, surname));
                            }
                        }
                    }
                }

                bookDao.update(book);

            } else if (action == 5) {

                logger.info("Enter the id of deleting book: ");
                id = scanner.nextInt();

                Book book = new Book();
                book.setId(id);

                int res = bookDao.delete(book);
                if (res > 0) logger.info(("Book deleted..."));
            }

        } while (action != 0);
    }
}