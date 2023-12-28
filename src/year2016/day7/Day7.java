package year2016.day7;

import utils.ReadFile;

public class Day7 {
    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day7/input.txt");
        processLines(lines);
    }

    static void processLines(String lines) {
        int sum = 0;
        for (String line : lines.split("\n")) {
            if (ipSupportsTls(line))
                sum++;
        }
        System.out.println("Part 1: " + sum);
    }

    static boolean ipSupportsTls(String line) {
        line = line.replace("[", "-");
        line = line.replace("]", "-");
        int i = 0;
        boolean evenContainsPair = false;
        for (String ipString : line.split("-")) {
            if (i % 2 == 1) {
                if (containsDoublePair(ipString)) {
                    return false;
                }
            } else if (i % 2 == 0) {
                evenContainsPair = evenContainsPair || containsDoublePair(ipString);
            }
            i++;
        }
        return evenContainsPair;
    }

    static boolean containsDoublePair(String sequence) {
        int i = 0;
        boolean contains = false;
        while (i < sequence.length() - 3 && !contains) {
            if (sequence.charAt(i) == sequence.charAt(i + 3) &&
                    sequence.charAt(i + 1) == sequence.charAt(i + 2) &&
                    sequence.charAt(i) != sequence.charAt(i + 2)) {
                contains = true;
            }
            i++;
        }
        return contains;
    }
}
