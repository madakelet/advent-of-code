package year2016.day7;

import java.util.ArrayList;
import java.util.List;

import utils.ReadFile;

public class Day7 {
    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day7/input.txt");
        processLines(lines);
    }

    static void processLines(String lines) {
        int sum = 0;
        int sumPartTwo = 0;
        for (String line : lines.split("\n")) {
            if (ipSupportsTls(line))
                sum++;
            if (ipSupportsSsl(line))
                sumPartTwo++;
        }
        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + sumPartTwo);
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

    static boolean ipSupportsSsl(String line) {
        line = line.replace("[", "-");
        line = line.replace("]", "-");

        int i = 0;

        StringBuilder outers = new StringBuilder();
        StringBuilder inners = new StringBuilder();

        for (String ipString : line.split("-")) {
            if (i % 2 == 0) {
                outers.append(ipString).append("-");
            } else if (i % 2 == 1) {
                inners.append(ipString).append("-");
            }
            i++;
        }

        List<String> sandwiches = sandwichesList(outers.toString());
        
        return containsBoth(sandwiches, inners.toString());
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

    static List<String> sandwichesList(String sequence) {
        List<String> sandwiches = new ArrayList<>();
        int i = 0;
        while (i < sequence.length() - 2) {
            if (sequence.charAt(i) == sequence.charAt(i + 2) &&
                    sequence.charAt(i) != sequence.charAt(i + 1) &&
                    sequence.charAt(i + 1) != '-') {
                StringBuilder builder = new StringBuilder();
                builder.append(sequence.charAt(i + 1)).append(sequence.charAt(i)).append(sequence.charAt(i + 1));
                sandwiches.add(builder.toString());
            }
            i++;
        }
        return sandwiches;
    }

    static boolean containsBoth(List<String> sandwiches, String inners) {
        boolean contains = false;
        for(String sandwich : sandwiches) {
            if(inners.contains(sandwich)) {
                contains = true;
            }
        }

        return contains;
    }
}
