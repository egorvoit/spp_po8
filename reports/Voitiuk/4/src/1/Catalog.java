import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<BookHistory> bookHistories;

    public Catalog() {
        this.bookHistories = new ArrayList<>();
    }

    public void addBookHistory(String bookName, String readerName) {
        this.bookHistories.add(new BookHistory(bookName, readerName));
    }

    public void printBookHistories() {
        for (BookHistory bookHistory : bookHistories) {
            System.out.println(bookHistory);
        }
    }
    public void addBookHistoryFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                if (parts.length >= 2) {
                    String bookName = parts[0];
                    String readerName = parts[1];
                    addBookHistory(bookName, readerName);
                } else {
                    System.out.println("Ignoring invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private class BookHistory {
        private String bookName;
        private String readerName;

        public BookHistory(String bookName, String readerName) {
            this.bookName = bookName;
            this.readerName = readerName;
        }

        @Override
        public String toString() {
            return "Book '" + bookName + "' was issued to " + readerName;
        }
    }
}
