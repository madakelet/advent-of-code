package year2016.day12;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import utils.Point;

public class Day12 {

    static boolean isOpenSpace(int x, int y, int favoriteNumber) {
        int value = x * x + 3 * x + 2 * x * y + y + y * y + favoriteNumber;
        String binaryRepresentation = Integer.toBinaryString(value);
        long countBits = binaryRepresentation.chars().filter(c -> c == '1').count();
        return countBits % 2 == 0;
    }

    static int shortestPathLength(Point start, Point target, int favoriteNumber) {
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

                // if (current.equals(target)) {
                //     System.out.println("Part 1: " + steps);
                //     return 0;
                // }
                if(steps == 50) {
                System.out.println("Part 2: " + visited.size());
                return 0;
                }
                for (int[] dir : directions) {
                    int newX = current.x + dir[0];
                    int newY = current.y + dir[1];

                    Point next = new Point(newX, newY);

                    if (newX >= 0 && newY >= 0 && isOpenSpace(newX, newY, favoriteNumber) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Point start = new Point(1, 1);
        Point end = new Point(31, 39);
        int favoriteNumber = 1350;
        shortestPathLength(start, end, favoriteNumber);
    }
}
