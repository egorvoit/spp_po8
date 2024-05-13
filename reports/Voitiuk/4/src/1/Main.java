import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.addBookHistoryFromFile("C:/Users/egor-/IdeaProjects/lab4task1/src/books.txt");
        catalog.printBookHistories();
    }
}

