import db.dao.BookDAOImpl;
import db.dao.ConnectionToDB;
import db.dao.IBookDAO;
import db.entity.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IBookDAO bookDao = new BookDAOImpl(new ConnectionToDB());
        Scanner scanner = new Scanner(System.in);
        String bookName;
        long bookId;
        int action;

        do {
            System.out.println("\n\nMenu:");
            System.out.println("[1] add book");
            System.out.println("[2] show book from id");
            System.out.println("[3] show all books");
            System.out.println("[4] update book");
            System.out.println("[5] delete book from id");
            System.out.println("[0] exit");
            System.out.print("\nEnter an action: ");
            action = scanner.nextInt();

            if (action == 1) {

                System.out.print("Enter the name of book: ");
                bookName = scanner.next();

                Book book = new Book();
                book.setName(bookName);

                bookDao.save(book);

            } else if (action == 2) {

                System.out.print("Enter the id from book: ");
                bookId = scanner.nextInt();

                Book book = bookDao.findById(bookId);

                if (book != null) System.out.println(book);
                else System.out.println("\nBook with ID " + bookId + " not found!");

            } else if (action == 3) {

                List<Book> list = bookDao.getAll();

                if (list != null) {
                    for (Book book : list) {
                        System.out.println(book);
                    }
                } else {
                    System.out.println("\nTable is empty...");
                }

            } else if (action == 4) {

                System.out.print("Enter the id of book: ");
                bookId = scanner.nextInt();

                System.out.print("Enter the new name for book: ");
                bookName = scanner.next();

                Book book = new Book(bookId, bookName);
                bookDao.update(book);

            } else if (action == 5) {

                System.out.print("Enter the id of deleting book: ");
                bookId = scanner.nextInt();

                Book book = new Book();
                book.setId(bookId);

                int res = bookDao.delete(book);

                if (res > 0) System.out.println(("\nBook deleted..."));
                else System.out.println(("\nBook with ID " + book.getId() + " not found..."));
            }

        } while (action != 0);
    }
}