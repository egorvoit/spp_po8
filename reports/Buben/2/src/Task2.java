import java.io.IOException;
import java.io.RandomAccessFile;

public class Tas {
    public static void main(String[] args) {
        if (!args[0].equals("tail") || (args.length < 2 || args.length > 4)) {
            System.err.println("Usage: tail [-n <number_of_lines>] <file>");
            return;
        }

        int numberOfLines = 10;
        String fileName = "";
        int argIndex = 1;

        if (args[argIndex].equals("-n")) {
            try {
                numberOfLines = Integer.parseInt(args[argIndex + 1]);
                argIndex += 2;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format");
                return;
            }
        } else if (args[argIndex].matches("\\d+")) {
            numberOfLines = Integer.parseInt(args[argIndex]);
            argIndex++;
        }

        fileName = args[argIndex];

        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            long length = file.length();
            StringBuilder tail = new StringBuilder();
            long position = length - 1;
            int lines = 0;

            while (position >= 0 && lines < numberOfLines) {
                file.seek(position);
                char c = (char) file.read();
                if (c == '\n' && position != 0) {
                    lines++;
                }
                tail.insert(0, c);
                position--;
            }

            String result = tail.toString().trim();
            System.out.print(result);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
