package year2015.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        String input = "year2015/day3/input.txt";
        String directions = readFromFile(input);
        List<Point> visited = new ArrayList<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < directions.length(); i++) {
            char direction = directions.charAt(i);
            switch (direction) {
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
            }
            Point point = new Point(x, y);
            if (!visited.contains(point)) {
                visited.add(point);
            }
        }
        System.out.println("Part 1: " + visited.size());
    }

    public static String readFromFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException exception) {
            System.err.format("Exception occurred trying to read '%s'.", path);
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!Point.class.isAssignableFrom(obj.getClass())) {
                return false;
            }
            final Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }
    }
}
