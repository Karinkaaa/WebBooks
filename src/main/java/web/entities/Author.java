package web.entities;

public class Author {

    private Integer id = null;
    private String name;
    private String surname;

    public Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
