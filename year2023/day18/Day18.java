package day18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day18 {
    public static List<Point> points = new ArrayList<>();
    public static int currentX = 0;
    public static int currentY = 0;
    public static int boundary = 0;

    public static List<Point> secondPoints = new ArrayList<>();
    public static long secondBoundary = 0;
    public static int secondCurrentX = 0;
    public static int secondCurrentY = 0;

    public static void main(String[] args) {
        readFromFile("year2023/day18/input.txt");
        System.out.println("Pick's formula: " + calculatePicksFormula(points, boundary));
        System.out.println("Pick's formula part 2: " + calculatePicksFormula(secondPoints, secondBoundary));

    }

    public static void readFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processLine(String line) {
        String[] exploded = line.split(" ");
        String direction = exploded[0];
        int distance = Integer.parseInt(exploded[1]);
        String color = exploded[2];
        processColor(color);
        boundary += distance;
        calculateCoordinate(direction, distance);
        Point p = new Point(currentX, currentY);
        points.add(p);
    }

    public static class Point {
        public long x;
        public long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static long calculateShoeLaceFormula(List<Point> points) {
        long sum = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get(i + 1);
            sum += currentPoint.x * nextPoint.y - currentPoint.y * nextPoint.x;
        }
        return Math.abs(sum) / 2;
    }

    public static long calculatePicksFormula(List<Point> points, long boundary) {
        return calculateShoeLaceFormula(points) + (boundary / 2) + 1;
    }

    public static void calculateCoordinate(String direction, int distance) {
        switch (direction) {
            case "R":
                currentX += distance;
                break;
            case "L":
                currentX -= distance;
                break;
            case "U":
                currentY += distance;
                break;
            case "D":
                currentY -= distance;
                break;
            default:
                // System.out.println("Unknown direction: " + direction);
                break;
        }
    }

    public static void calculateSecondCoordinate(int direction, long distance) {
        switch (direction) {
            case 0:
                secondCurrentX += distance;
                break;
            case 1:
                secondCurrentY -= distance;
                break;
            case 2:
                secondCurrentX -= distance;
                break;
            case 3:
                secondCurrentY += distance;
                break;
            default:
                System.out.println("Unknown direction: " + direction);
                break;
        }
    }

    public static void processColor(String color) {
        String trimmed = color.substring(2);
        trimmed = trimmed.substring(0, trimmed.length() - 1);
        long distance = hexToDecimal(trimmed.substring(0, trimmed.length() - 1));
        secondBoundary += distance;
        char direction = trimmed.charAt(trimmed.length() - 1);
        calculateSecondCoordinate(Integer.parseInt(String.valueOf(direction)), distance);

        Point p = new Point(secondCurrentX, secondCurrentY);
        secondPoints.add(p);
    }

    public static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}