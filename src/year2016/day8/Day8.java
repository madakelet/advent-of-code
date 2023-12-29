package year2016.day8;

import utils.ReadFile;

public class Day8 {
    static char[][] screen = new char[6][50];

    public static void main(String[] args) {
        fillScreenWithEmpty();
        String lines = ReadFile.readFromFile("src/year2016/day8/input.txt");
        processLines(lines);
        System.out.println("Part 1: " + countOnPixels());
        printScreen();
    }

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            if (line.contains("rect")) {
                addRectangle(line.split(" ")[1]);
            } else if (line.contains("rotate")) {
                rotateScreen(line);
            }
        }
    }

    static void fillScreenWithEmpty() {
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                screen[row][col] = '.';
            }
        }
    }

    static void printScreen() {
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                System.out.print(screen[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void addRectangle(String input) {
        String[] sides = input.split("x");
        int width = Integer.parseInt(sides[0]);
        int height = Integer.parseInt(sides[1]);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                screen[row][col] = '#';
            }
        }
    }

    static void rotateScreen(String rotationLine) {
        String[] split = rotationLine.split(" ");
        int axisToRotate = Integer.parseInt(split[2].split("=")[1]);
        int rotatationAmount = Integer.parseInt(split[4]);
        int numRows = screen.length;
        int numCols = screen[0].length;

        if (split[1].equals("column")) {

            // clone
            char[] colClone = new char[numRows];
            for (int row = 0; row < numRows; row++) {
                colClone[row] = screen[row][axisToRotate];
            }

            // move
            for (int row = 0; row < numRows; row++) {
                int placeToRotate = (row + rotatationAmount) % numRows;
                screen[placeToRotate][axisToRotate] = colClone[row];
            }
        } else if (split[1].equals("row")) {

            // clone
            char[] rowClone = screen[axisToRotate].clone();

            // move
            for (int col = 0; col < numCols; col++) {
                int placeToRotate = (col + rotatationAmount) % numCols;
                screen[axisToRotate][placeToRotate] = rowClone[col];
            }
        }
    }

    static int countOnPixels() {
        int sum = 0;
        for(int row = 0; row < screen.length; row++) {
            for(int col = 0; col < screen[row].length; col++) {
                if(screen[row][col] == '#') sum++;
            }
        }

        return sum;
    }
}
