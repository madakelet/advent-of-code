package year2016.day2;

import utils.ReadFile;

public class Day2 {
    static int currentStartingNumber = 5;
    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day2/input.txt");
        processLines(lines);
    }

    static void processLines(String lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines.split("\n")) {
            calculateLine(line);
            builder.append(Integer.toString(currentStartingNumber));
        }
        System.out.println(builder.toString());
    }

    static void calculateLine(String line) {
        System.out.print("After calculating for " + line + " with starting " + currentStartingNumber + ": ");
        for (char currentChar : line.toCharArray()) {
            currentStartingNumber = getNumberFromMove(currentStartingNumber, currentChar);
        }
        System.out.println(currentStartingNumber);
        System.out.println();
    }

    static int getNumberFromMove(int currentNumber, char move) {
        switch (move) {
            case 'U':
                if ((currentNumber - 3) > 0) {
                    currentNumber -= 3;
                }
                break;
            case 'D':
                if ((currentNumber + 3) < 10) {
                    currentNumber += 3;
                }
                break;
            case 'R':
                if (currentNumber % 3 != 0) {
                    currentNumber += 1;
                }
                break;
            case 'L':
                if (currentNumber % 3 != 1) {
                    currentNumber -= 1;
                }
            default:
                break;
        }
        return currentNumber;
    }
}
