import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Task2 {
    private static final int optionPattern = 0;
    private static final int optionValue = 1;
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].equals("nl")){
            System.err.println("Utility name - nl");
            System.exit(1);
        }
        Map<String, ArrayList<String>> options = new HashMap<>();
        options.put("-i", new ArrayList<>(Arrays.asList("^[1-9][0-9]*", "1")));
        options.put("-l", new ArrayList<>(Arrays.asList("[10]", "1")));
        options.put("-n", new ArrayList<>(Arrays.asList("ln|rn|rz", "ln")));
        ArrayList<String> params = new ArrayList<>();

        for (int i = 1; i < args.length; i++){
            if (args[i].startsWith("-") && args[i].length() > 1){
                if (params.isEmpty()
                        && options.containsKey(args[i])
                        && i < args.length + 1
                        && args[i+1].matches(options.get(args[i]).get(optionPattern))){
                    options.put(args[i], new ArrayList<>(Arrays.asList(
                            (options.get(args[i]).get(optionPattern)),
                            args[++i])));
                }
                else {
                    System.out.println("Wrong option " + args[i]);
                    System.exit(1);
                }
            }
            else {
                params.add(args[i]);
            }
        }

        if (params.isEmpty() || params.size() > 2){
            System.out.println("Wrong params count");
            System.exit(1);
        }
        if (params.size() == 2 && params.getFirst().equals(params.getLast())){
            System.out.println("Input file can't be output file");
            System.exit(1);
        }

        Scanner scanner;
        File inFile;
        if (!params.getFirst().equals("-")){
            inFile = new File(params.getFirst());
            if (!inFile.isFile()){
                System.err.println("Input file doesn't exist");
                System.exit(1);
            }
            scanner = new Scanner(inFile);
        }
        else {
            scanner = new Scanner(System.in);
        }

        PrintStream outputStream;
        FileOutputStream  fileOutputStream;
        if (params.size() == 2){
            File outFile = new File(params.getLast());
            if (!outFile.isFile()){
                if (!outFile.createNewFile()){
                    System.err.println("Failed to create output file");
                    System.exit(1);
                }
            }
            fileOutputStream = new FileOutputStream(params.getLast());
            outputStream = new PrintStream(fileOutputStream);
        }
        else {
            outputStream = new PrintStream(System.out);
        }

        int step = Integer.parseInt(options.get("-i").get(optionValue));
        boolean countEmptyLines = "1".equals(options.get("-l").get(optionValue));
        String alignType = options.get("-n").get(optionValue);
        String line;
        for (int lineNumber = 1; scanner.hasNextLine();){
            line = scanner.nextLine();
            if (line.equals("\\q"))
                break;

            if (countEmptyLines || !line.isEmpty()){
                switch (alignType) {
                    case "ln":
                        line = lineNumber + " -- " + line;
                        break;
                    case "rn":
                        line = line + " -- " + lineNumber;
                        break;
                    case "rz":
                        line = line + " -- " + String.format("%4s", lineNumber).replace(' ', '0');
                        break;
                }
                lineNumber += step;
            }

            outputStream.println(line);
        }
    }
}
