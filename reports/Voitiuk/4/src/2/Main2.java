import java.util.ArrayList;

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int length() {
        return word.length();
    }
}

class Page {
    private ArrayList<Word> words;

    public Page(ArrayList<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public int wordCount() {
        return words.size();
    }

    public void displayWords() {
        System.out.println("Слова на странице:");
        for (Word word : words) {
            System.out.print(word.getWord() + " ");
        }
        System.out.println();
    }
    public int totalLength() {
        int totalLengthOfWords = 0;
        for (Word word : words) {
            totalLengthOfWords += word.length();
        }
        return totalLengthOfWords;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Word word1 = new Word("Егор");
        Word word2 = new Word("Войтюк");

        ArrayList<Word> pageWords = new ArrayList<>();
        pageWords.add(word1);
        pageWords.add(word2);
        Page page = new Page(pageWords);

        Word word3 = new Word("Олегович");
        page.addWord(word3);

        page.displayWords();

        System.out.println("Общее количество слов на странице: " + page.wordCount());
        System.out.println("Общая длина слов на странице: " + page.totalLength());
    }
}