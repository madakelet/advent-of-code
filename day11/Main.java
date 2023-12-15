package day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> lines = new ArrayList<>();
    public static List<Galaxy> galaxies = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = "day11/input.txt";
        readToList(filePath);
        char[][] sky = createSky();
        expandSky(true);
        expandSky(false);
        System.out.println("distances: " + measureDistances());
    }

    public static void readToList(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char[][] createSky() {
        int rows = lines.size();
        int cols = lines.stream().mapToInt(String::length).max().orElse(0);
        char[][] sky = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < cols; j++) {
                if (line.charAt(j) == '#') {
                    Galaxy galaxy = new Galaxy(j ,i);
                    galaxies.add(galaxy);
                }
                sky[i][j] = line.charAt(j);
            }
        }

        return sky;
    }

    public static void printSky(char[][] sky) {
        for (char[] row : sky) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void expandSky(boolean isHorizontal) {
        List<Integer> empties = new ArrayList<>();
        int length = isHorizontal ? lines.get(0).length() : lines.size();
        int innerLength = isHorizontal ? lines.size() : lines.get(0).length();
        for (int i = 0; i < length; i++) {
            boolean isEmpty = true;
            for (int j = 0; j < innerLength; j++) {
                if (isHorizontal) {
                    if (lines.get(i).charAt(j) != '.') {
                        isEmpty = false;
                        break;
                    }
                } else {
                    if (lines.get(j).charAt(i) != '.') {
                        isEmpty = false;
                        break;
                    }
                }
            }
            if (isEmpty) {
                empties.add(i);
            }
        }
        System.out.println(empties);

        for (Galaxy galaxy : galaxies) {
            int numbersToExpand = 0;
            for (int empty : empties) {
                if (isHorizontal) {
                    if (galaxy.y > empty) {
                        numbersToExpand++;
                    }
                } else {
                    if (galaxy.x > empty) {
                        numbersToExpand++;
                    }
                }
            }
            if (isHorizontal) {
                galaxy.y += numbersToExpand;
            } else {
                galaxy.x += numbersToExpand;
            }
        }
    }

    public static void printGalaxies() {
        for (Galaxy galaxy : galaxies) {
            System.out.println(galaxy.x + " " + galaxy.y);
        }
    }

    public static int measureDistances() {
        int sum = 0;
        int size = galaxies.size();
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                sum += galaxies.get(i).distance(galaxies.get(j));
            }
        }
        return sum;
    }

}
