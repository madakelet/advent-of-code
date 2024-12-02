package exercise;

import java.util.ArrayList;
import java.util.List;

import utils.ReadFile;

public class DFS {

    static int minDistance = Integer.MAX_VALUE;

    static boolean isSafe(List<List<Point>> maze, Point point) {
        return point.x >= 0 &&
                point.y >= 0 &&
                point.x < maze.size() &&
                point.y < maze.get(0).size() &&
                maze.get(point.x).get(point.y).value != '#' &&
                !maze.get(point.x).get(point.y).visited;
    }

    static void findShortestPath(List<List<Point>> maze, Point source, Point destination, int distance) {
        if (source.x == destination.x && source.y == destination.y) {
            minDistance = Math.min(minDistance, distance);
            return;
        }
        maze.get(source.x).get(source.y).visited = true;

        Point right = new Point(source.x + 1, source.y);
        Point left = new Point(source.x - 1, source.y);
        Point top = new Point(source.x, source.y + 1);
        Point bottom = new Point(source.x, source.y - 1);

        if (isSafe(maze, right)) {
            findShortestPath(maze, right, destination, distance + 1);
        }
        if (isSafe(maze, left)) {
            findShortestPath(maze, left, destination, distance + 1);
        }
        if (isSafe(maze, top)) {
            findShortestPath(maze, top, destination, distance + 1);
        }
        if (isSafe(maze, bottom)) {
            findShortestPath(maze, bottom, destination, distance + 1);
        }

        maze.get(source.x).get(source.y).visited = false;

    }

    static void printMaze(List<List<Point>> maze) {
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(0).size(); j++) {
                System.out.print(maze.get(i).get(j).value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Point>> maze = new ArrayList<>();
        String mazeInput = ReadFile.readFromFile("src/exercise/maze.txt");
        int row = 0;
        for (String line : mazeInput.split("\n")) {
            int col = 0;
            List<Point> currentRow = new ArrayList<>();
            for (char c : line.toCharArray()) {
                Point p = new Point(row, col, c);
                currentRow.add(p);
                col++;
            }
            maze.add(currentRow);
            row++;
        }
        Point start = new Point(1, 1);
        Point end = new Point(9, 11);
        findShortestPath(maze, start, end, 0);
        if (minDistance != Integer.MAX_VALUE) {
            System.out.println("Shortest distance: " + minDistance);
        } else
            System.out.print("Not reachable");
    }

    static class Point {
        int x;
        int y;
        char value;
        boolean visited = false;

        public Point() {
            x = 0;
            y = 0;
            value = '.';
        }

        public Point(int x, int y, char value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        /**
         * Constructor with two parameters (x,ys).
         *
         * @param x Value of x axis
         * @param y Value of y axis.
         **/

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            value = '.';
        }

        @Override

        public String toString() {
            return "(" + x + ", " + y + ")" + ": " + value;
        }
    }
}
