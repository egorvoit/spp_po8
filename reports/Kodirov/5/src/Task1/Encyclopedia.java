import java.util.Objects;

public class Encyclopedia extends Book {
    private int numberOfVolumes;

    public Encyclopedia(int cypher, String author, String name, int year, String publishingHouse, int numberOfVolumes) {
        super(cypher, author, name, year, publishingHouse);
        this.numberOfVolumes = numberOfVolumes;
    }

    @Override
    public void printInfo() {
        System.out.println("Энциклопедия:\nШифр: " + super.cypher
                + "\nАвтор: " + super.author
                + "\nНазвание: " + super.name
                + "\nГод: " + super.year
                + "\nИздательство: " + super.publisher
                + "\nКоличество томов: " + numberOfVolumes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encyclopedia that)) return false;
        if (!super.equals(o)) return false;
        return numberOfVolumes == that.numberOfVolumes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfVolumes);
    }
}
