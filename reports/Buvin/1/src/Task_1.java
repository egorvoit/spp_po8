import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("\n" + "Not enough arguments. Please enter the sequence of numbers.");
            return;
        }

        int[] sequence = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            sequence[i - 1] = Integer.parseInt(args[i]);
        }

        List<Integer> modes = findMode(sequence);

        if (modes.isEmpty()) {
            System.out.println("Sequence has no mode");
        } else {
            System.out.print("\n" + "Sequence mode(s):");
            for (int mode : modes) {
                System.out.print(mode + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> findMode(int[] sequence) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : sequence) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> modes = new ArrayList<>();
        int maxFrequency = 0;

        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }
}