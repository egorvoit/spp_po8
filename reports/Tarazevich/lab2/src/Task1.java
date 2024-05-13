import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task1 {
    private static String filePath = "src/task1.txt";
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        Map<String, Integer> wordCount = new HashMap<>();
        String word;
        while (scanner.hasNext()) {
            word = scanner.next();
            word = word.replaceAll("[^a-zA-Z0-9']", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();

        List<Map.Entry<String, Integer>> wordCountSorted = new ArrayList<>(wordCount.entrySet());
        wordCountSorted.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        for (Map.Entry<String, Integer> pair : wordCountSorted) {
            System.out.println(pair.getValue() + " - " + pair.getKey());
        }
    }
}