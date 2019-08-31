package db.entity;

public class Book {

    private long id;
    private String name;

    public Book() {
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("\nBOOK:\n");
        sb.append("\nID: ").append(this.getId());
        sb.append("\nName: ").append(this.getName()).append("\n");
        return sb.toString();
    }
}
