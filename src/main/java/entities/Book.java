package entities;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Integer id = null;
    private String name;
    private List<Author> authors;

    public Book() {
        this.authors = new ArrayList<>();
    }

    public Book(Integer id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public Book(Integer id, String name, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setAuthor(Author author) {
        authors.add(author);
    }

    public Author getAuthorById(int id) {
        return (id > authors.size()) ? null : authors.get(id);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("\nBOOK:\n");
        sb.append("\nID: ").append(getId());
        sb.append("\nName: ").append(getName());
        sb.append("\nAuthors: ");

        if (authors.size() == 0) {
            sb.append("book without author...");

        } else {
            for (Author author : authors)
                sb.append(author).append(", ");

            sb.deleteCharAt(sb.length() - 2);
        }
        return sb.toString();
    }
}
