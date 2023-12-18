package day18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Point> points = new ArrayList<>();
    public static int currentX = 0;
    public static int currentY = 0;
    public static int boundary = 0;

    public static void main(String[] args) {
        readFromFile("day18/input.txt");
        System.out.println("Pick's formula: " + calculatePicksFormula());
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
                break;
        }
        boundary += distance;
        Point p = new Point(currentX, currentY, color);
        points.add(p);
    }

    public static class Point {
        public int x;
        public int y;
        public String color;

        public Point(int x, int y, String color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static int calculateShoeLaceFormula() {
        int sum = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get(i + 1);
            sum += currentPoint.x * nextPoint.y - currentPoint.y * nextPoint.x; 
        }
        return Math.abs(sum) / 2;
    }

    public static int calculatePicksFormula() {
        return calculateShoeLaceFormula() + (boundary / 2) + 1; 
    }
}