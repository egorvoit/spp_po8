import java.util.Objects;

public class Handbook extends Book {
    private int numberOfSections;

    public Handbook(int cypher, String author, String name, int year, String publishingHouse, int numberOfSections) {
        super(cypher, author, name, year, publishingHouse);
        this.numberOfSections = numberOfSections;
    }

    @Override
    public void printInfo() {
        System.out.println("Справочник:\nШифр: " + super.cypher
                + "\nАвтор: " + super.author
                + "\nНазвание: " + super.name
                + "\nГод: " + super.year
                + "\nИздательство: " + super.publisher
                + "\nКоличество разделов: " + numberOfSections);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Handbook handbook)) return false;
        if (!super.equals(o)) return false;
        return numberOfSections == handbook.numberOfSections;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSections);
    }
}
