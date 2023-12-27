package year2016.day2;

import utils.ReadFile;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    static int currentStartingNumber = 5;
    static char partTwoStartingNumber = '5';
    static List<Integer> edges = new ArrayList<>();

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day2/test.txt");
        addEdges();
        processLines(lines);
    }

    static void processLines(String lines) {
        StringBuilder builder = new StringBuilder();
        StringBuilder partTwoBuilder = new StringBuilder();
        for (String line : lines.split("\n")) {
            calculateLine(line);
            builder.append(Integer.toString(currentStartingNumber));
            partTwoBuilder.append(partTwoStartingNumber);
        }
        System.out.println("Part 1: " + builder.toString());
        System.out.println("Part 2: " + partTwoBuilder.toString());
    }

    static void calculateLine(String line) {
        //System.out.print("After calculating for " + line + " with starting " + currentStartingNumber + ": ");
        for (char currentChar : line.toCharArray()) {
            getNumberFromMove(currentChar);
            getNumberFromMovePartTwo(currentChar);
        }
        //System.out.println(currentStartingNumber);
    }

    static void getNumberFromMove(char move) {
        switch (move) {
            case 'U':
                if ((currentStartingNumber - 3) > 0) {
                    currentStartingNumber -= 3;
                }

                break;
            case 'D':
                if ((currentStartingNumber + 3) < 10) {
                    currentStartingNumber += 3;
                }
                break;
            case 'R':
                if (currentStartingNumber % 3 != 0) {
                    currentStartingNumber += 1;
                }
                break;
            case 'L':
                if (currentStartingNumber % 3 != 1) {
                    currentStartingNumber -= 1;
                }
            default:
                break;
        }
    }

    static void getNumberFromMovePartTwo(char move) {
        //partTwoStartingNumber = Character.getNumericValue(partTwoStartingNumber) - 4;
        switch (move) {
            case 'U':
                if (partTwoStartingNumber != '1' &&
                        partTwoStartingNumber != '2' &&
                        partTwoStartingNumber != '4' &&
                        partTwoStartingNumber != '5' &&
                        partTwoStartingNumber != '9') {
                }

                break;

            default:
                break;
        }
    }

    static void addEdges() {
        edges.add(1);
        edges.add(2);
        edges.add(4);
        edges.add(9);
    }
}
