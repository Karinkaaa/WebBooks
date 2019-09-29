package web.entities;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private int id;
    private String name;
    private String surname;
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(int id, String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(int id, String name, String surname, List<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Author) {
            return (id == ((Author) obj).getId());
        }
        return false;
    }
}
