package year2016.day1;

import java.util.ArrayList;
import java.util.List;
import utils.Line;
import utils.Point;
import utils.ReadFile;

public class Day1 {
    public static void main(String[] args) {
        List<Line> linesArray = new ArrayList<>();
        String lines = ReadFile.readFromFile("src/year2016/day1/input.txt");
        char facing = 'N';
        int x = 0, y = 0;
        String[] steps = processLines(lines);
        for (String step : steps) {
            Line newLine = new Line();
            newLine.start.x = x;
            newLine.start.y = y;
            newLine.end.x = x;  
            newLine.end.y = y;
            char direction = step.charAt(0);
            int distance = Integer.parseInt(step.substring(1).trim());
            facing = getFacing(facing, direction);
            switch (facing) {
                case 'N':
                    newLine.end.y += distance;
                    y += distance;
                    break;
                case 'E':
                    newLine.end.x += distance;
                    x += distance;
                    break;
                case 'S':
                    newLine.end.y -= distance;
                    y -= distance;
                    break;
                case 'W':
                    newLine.end.x -= distance;
                    x -= distance;
                    break;
            }
            for (int i = 0; i < linesArray.size() - 1; i++) {
                if (linesArray.get(i).doesIntersect(newLine)) {
                    Point p = linesArray.get(i).intersectionPoint(newLine);
                    System.out.println("Part 2: at coordinate " + p.toString() + " is " + (Math.abs(p.x) + Math.abs(p.y)) + " blocks away.");
                    break;
                }
            }
            linesArray.add(newLine);
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

    static void printLinesArray(List<Line> linesArray) {
        for(Line line : linesArray) {
            System.out.println(line.toString());
        }
    }
}
