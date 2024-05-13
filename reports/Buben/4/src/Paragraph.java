import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<MyString> lines;

    public Paragraph() {
        this.lines = new ArrayList<>();
    }

    public void addString(MyString line) {
        lines.add(line);
    }

    public void printParagraph() {
        for (MyString line : lines) {
            line.printString();
        }
    }

    public int getStringCount() {
        return lines.size();
    }
}


