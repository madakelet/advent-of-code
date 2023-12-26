package year2016.day1;

import java.util.HashMap;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {
        Map<String, Integer> visited = new HashMap<>();
        String lines = utils.ReadFile.readFromFile("src/year2016/day1/input.txt");
        char facing = 'N';
        int x = 0, y = 0;
        String[] steps = processLines(lines);
        for (String step : steps) {
            char direction = step.charAt(0);
            int distance = Integer.parseInt(step.substring(1).trim());
            facing = getFacing(facing, direction);
            switch (facing) {
                case 'N':
                    y += distance;
                    break;
                case 'E':
                    x += distance;
                    break;
                case 'S':
                    y -= distance;
                    break;
                case 'W':
                    x -= distance;
                    break;
            }
            String key = x + "," + y;
            System.out.println(key);
        }
        System.out.println("Part 1: " + (Math.abs(x) + Math.abs(y)));
    }

    static String[] processLines(String lines) {
        return lines.split(", ");
    }

    static char getFacing(char facing, char direction) {
        if (direction == 'R') {
            switch (facing) {
                case 'N':
                    return 'E';
                case 'E':
                    return 'S';
                case 'S':
                    return 'W';
                case 'W':
                    return 'N';
            }
        } else if (direction == 'L') {
            switch (facing) {
                case 'N':
                    return 'W';
                case 'E':
                    return 'N';
                case 'S':
                    return 'E';
                case 'W':
                    return 'S';
            }
        }
        return facing;
    }
}
