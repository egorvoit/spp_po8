import java.util.Objects;

public abstract class Book {
    protected int cypher;
    protected String author;
    protected String name;
    protected int year;
    protected String publisher;

    public Book(int cypher, String author, String name, int year, String publisher) {
        this.cypher = cypher;
        this.author = author;
        this.name = name;
        this.year = year;
        this.publisher = publisher;
    }

    public abstract void printInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return cypher == book.cypher && year == book.year && Objects.equals(author, book.author) && Objects.equals(name, book.name) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cypher, author, name, year, publisher);
    }
}
