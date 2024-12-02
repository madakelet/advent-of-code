package year2016.day6;

import java.util.List;
import java.util.Map;
import utils.ReadFile;
import java.util.ArrayList;
import java.util.HashMap;

public class Day6 {
    static List<Map<Character, Integer>> columns = new ArrayList<>();

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day6/input.txt");
        processLines(lines);
        StringBuilder builder = new StringBuilder();
        StringBuilder builderPartTwo = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            builder.append(chooseMostCommonCharacter(columns.get(i)));
            builderPartTwo.append(chooseLeastCommonCharacter(columns.get(i)));
        }
        System.out.println("Part 1: " + builder.toString());
        System.out.println("Part 2: " + builderPartTwo.toString());
    }

    static void processLines(String lines) {
        int i = 0;
        for (String line : lines.split("\n")) {
            if (i == 0)
                initCols(line);
            addCharsToMap(line);
            i++;
        }
    }

    static void initCols(String line) {
        for (int i = 0; i < line.length(); i++) {
            Map<Character, Integer> column = new HashMap<>();
            columns.add(column);
        }
    }

    static void addCharsToMap(String line) {
        int col = 0;
        for (char c : line.toCharArray()) {
            Map<Character, Integer> currentColMap = columns.get(col);
            currentColMap.put(c, currentColMap.getOrDefault(c, 0) + 1);
            col++;
        }
    }

    static char chooseMostCommonCharacter(Map<Character, Integer> column) {
        Map.Entry<Character, Integer> maxEntry = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : column.entrySet()) {
            if (entry.getValue().compareTo(maxValue) > 0) {
                maxValue = entry.getValue();
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    static char chooseLeastCommonCharacter(Map<Character, Integer> column) {
        Map.Entry<Character, Integer> minEntry = null;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : column.entrySet()) {
            if (entry.getValue().compareTo(minValue) < 0) {
                minEntry = entry;
                minValue = entry.getValue();
            }
        }
        return minEntry.getKey();
    }

    static void printMap(Map<Character, Integer> mapToPrint) {
        for (Map.Entry<Character, Integer> entry : mapToPrint.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
