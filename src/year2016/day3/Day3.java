package year2016.day3;

import java.util.ArrayList;
import java.util.List;

import utils.ReadFile;

public class Day3 {
    static List<Integer> col1 = new ArrayList<>();
    static List<Integer> col2 = new ArrayList<>();
    static List<Integer> col3 = new ArrayList<>();

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day3/input.txt");
        System.out.println("Part 1: " + processLines(lines));
        int sumPart2 = trianglesInList(col1) + trianglesInList(col2) + trianglesInList(col3);
        System.out.println("Part 2: " + sumPart2);
    }

    static int processLines(String lines) {
        int sum = 0;
        for (String line : lines.split("\n")) {
            line = line.trim();
            line = line.replaceAll("\\s+", " ");
            String[] triangles = line.split(" ");
            int side1 = Integer.parseInt(triangles[0]);
            int side2 = Integer.parseInt(triangles[1]);
            int side3 = Integer.parseInt(triangles[2]);

            col1.add(side1);
            col2.add(side2);
            col3.add(side3);

            if (isTriangle(side1, side2, side3)) {
                sum++;
            }
        }

        return sum;
    }

    static boolean isTriangle(int side1, int side2, int side3) {
        return ((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1);
    }

    static int trianglesInList(List<Integer> triangels) {
        int sum = 0;
        for (int i = 0; i < triangels.size() - 2; i += 3) {
            int side1 = triangels.get(i);
            int side2 = triangels.get(i + 1);
            int side3 = triangels.get(i + 2);
            if (isTriangle(side1, side2, side3))
                sum++;
        }
        return sum;
    }
}
