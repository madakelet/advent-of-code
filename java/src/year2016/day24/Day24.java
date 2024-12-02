package year2016.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Map;

import utils.ReadFile;
import utils.Point;
import utils.Permutations;

public class Day24 {

    static List<List<Point>> maze = new ArrayList<>();
    static List<Point> pointsToVisit = new ArrayList<>();
    static Map<Character, Map<Character, Integer>> distances = new HashMap<>();

    static void processLines(String lines) {
        int row = 0;
        for (String line : lines.split("\n")) {
            List<Point> currentRow = new ArrayList<>();
            int col = 0;
            for (char c : line.toCharArray()) {
                Point p = new Point(row, col, c);
                if (Character.isDigit(c)) {
                    pointsToVisit.add(p);
                }
                currentRow.add(p);
                col++;
            }
            maze.add(currentRow);
            row++;
        }
    }

    static boolean isSafe(List<List<Point>> maze, Point point, Set<Point> visited) {
        return point.x >= 0 &&
                point.y >= 0 &&
                point.x < maze.size() &&
                point.y < maze.get(0).size() &&
                maze.get(point.x).get(point.y).value != '#' &&
                !visited.contains(point);
    }

    static void printMaze(List<List<Point>> maze) {
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(0).size(); j++) {
                System.out.print(maze.get(i).get(j).value);
            }
            System.out.println();
        }
    }

    static int shortestPathLength(Point start, Point target) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Queue<Point> queue = new ArrayDeque<>();
        Set<Point> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                if (current.x == target.x && current.y == target.y) {
                    return steps;
                }
                for (int[] dir : directions) {
                    int newX = current.x + dir[0];
                    int newY = current.y + dir[1];

                    Point next = new Point(newX, newY);
                    if (isSafe(maze, next, visited)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    static void findPaths() {
        for (int i = 0; i < pointsToVisit.size(); i++) {
            Point start = pointsToVisit.get(i);
            distances.put(start.value, new HashMap<>());
            for (int j = 0; j < pointsToVisit.size(); j++) {
                if (i != j) {
                    Point end = pointsToVisit.get(j);
                    int distance = shortestPathLength(start, end);
                    distances.get(start.value).put(end.value, distance);

                    if (!distances.containsKey(end.value)) {
                        distances.put(end.value, new HashMap<>());
                    }

                    distances.get(end.value).put(start.value, distance);
                }
            }
        }
    }

    static void printDistances() {
        for (Character from : distances.keySet()) {
            for (Character to : distances.get(from).keySet()) {
                System.out.println(from + " -> " + to + " = " + distances.get(from).get(to));
            }
        }
    }

    static int pathDistance(Character[] path, boolean partOne) {
        int distance = 0;
        for (int i = 0; i < path.length - 1; i++) {
            distance += distances.get(path[i]).get(path[i + 1]);
        }
        if (!partOne) {
            distance += distances.get(path[path.length - 1]).get('0');
        }
        return distance;
    }

    static Character[] findShortestPath(boolean partOne) {
        Character[] points = distances.keySet().toArray(Character[]::new);
        List<Character[]> paths = Permutations.permutations(points);
        Character[] shortestPath = null;
        int minDistance = Integer.MAX_VALUE;
        for (Character[] path : paths) {
            if (path[0] == '0') {
                int distance = pathDistance(path, partOne);
                if (distance < minDistance) {
                    minDistance = distance;
                    shortestPath = path;
                }
            }
        }
        return Arrays.copyOf(shortestPath, shortestPath.length);
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day24/input.txt");
        processLines(lines);
        findPaths();
        Character[] shortestPath = findShortestPath(true);
        int shortestDistance = pathDistance(shortestPath, true);
        System.out.println("Shortest path: " + Arrays.toString(shortestPath) + " distance: " + shortestDistance);
        shortestPath = findShortestPath(false);
        shortestDistance = pathDistance(shortestPath, false);
        System.out.println("Shortest path back to 0: " + Arrays.toString(shortestPath) + " distance: " + shortestDistance);
    }

}
