package year2015.day24;

import java.util.List;
import java.util.ArrayList;

public class Day24 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day24/input.txt");
        List<Integer> numbers = processLine(lines);
    }

    static List<Integer> processLine(String lines) {
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines.split("\n")) {
            numbers.add(Integer.parseInt(line));
        }
        return numbers;
    }
}
