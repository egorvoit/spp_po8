public class Abbreviator {
    public static void main(String[] args) {
        String input = "Tom Clansys Rainbow Six Siege";
        String abbreviation = abbreviate(input);
        System.out.println("Abbreviation: " + abbreviation);
    }

    public static String abbreviate(String str) {
        String[] words = str.split(" ");
        StringBuilder abbreviation = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                abbreviation.append(word.charAt(0));
            }
        }

        return abbreviation.toString().toUpperCase();
    }
}
