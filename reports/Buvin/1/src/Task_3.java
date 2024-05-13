public class Task_3 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Not enough arguments. Please provide a string to check for pangram.");
            return;
        }

        String str = args[0];
        boolean isPangram = pangramEng(str);

        if (isPangram) {
            System.out.println("This string is a pangram.");
        } else {
            System.out.println("This line is not a pangram.");
        }
    }

    public static boolean pangramEng(String str) {
        str = str.toLowerCase();
        boolean[] seen = new boolean[26];

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
        }

        for (boolean letter : seen) {
            if (!letter) {
                return false;
            }
        }

        return true;
    }
}