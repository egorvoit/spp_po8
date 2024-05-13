public class Task2 {
    public static void main(java.lang.String[] args) {
        MyString line1 = new MyString("The first string");
        MyString line2 = new MyString("This is the second string");
        MyString line3 = new MyString("And here is another one");

        Paragraph paragraph = new Paragraph();
        paragraph.addString(line1);
        paragraph.addString(line2);
        paragraph.addString(line3);

        paragraph.printParagraph();
        System.out.println("Total length of strings: " + paragraph.getStringCount());
    }
}
