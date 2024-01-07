package year2016.day21;

import java.util.ArrayList;
import java.util.List;
import utils.ReadFile;

public class Day21 {
    static List<String> operations = new ArrayList<>();

    static void porcessLines(String lines) {
        for (String line : lines.split("\n")) {
            operations.add(line);
        }
    }

    static String swap(String input, String operation) {
        String[] splitted = operation.split(" ");
        int index1;
        int index2;

        if (operation.contains("position")) {
            index1 = Integer.parseInt(splitted[2]);
            index2 = Integer.parseInt(splitted[splitted.length - 1]);
        } else {
            index1 = input.indexOf(splitted[2]);
            index2 = input.indexOf(splitted[splitted.length - 1]);
        }

        char[] charArray = input.toCharArray();
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;

        return new String(charArray);
    }

    static String rotate(String input, String operation, boolean reverse) {
        String[] splitted = operation.split(" ");
        if (operation.contains("left")) {
            return reverse ? rotateRight(input, splitted[2]) : rotateLeft(input, splitted[2]);
        } else if (operation.contains("right")) {
            return reverse ? rotateLeft(input, splitted[2]) : rotateRight(input, splitted[2]);
        } else {
            return rotateBasedOnPosition(input, splitted[splitted.length - 1], reverse);
        }
    }

    static String rotateLeft(String input, String stespString) {
        int steps = Integer.parseInt(stespString);
        steps = steps % input.length();
        return input.substring(steps) + input.substring(0, steps);
    }

    static String rotateRight(String input, String stepsString) {
        int steps = Integer.parseInt(stepsString);
        steps = steps % input.length();
        return input.substring(input.length() - steps) + input.substring(0, input.length() - steps);
    }

    static String rotateBasedOnPosition(String input, String target, boolean reverse) {
        int index = input.indexOf(target);
        int rotateSteps = 1 + index + (index >= 4 ? 1 : 0);
        return reverse ? rotateLeft(input, Integer.toString(rotateSteps))
                : rotateRight(input, Integer.toString(rotateSteps));

    }

    static String reverseSubString(String input, String operation) {
        String[] splitted = operation.split(" ");
        int startIndex = Integer.parseInt(splitted[2]);
        int endIndex = Integer.parseInt(splitted[splitted.length - 1]);
        String before = input.substring(0, startIndex);
        String toReverse = input.substring(startIndex, endIndex + 1);
        String after = input.substring(endIndex + 1);

        StringBuilder reversed = new StringBuilder(toReverse);
        reversed.reverse();

        return before + reversed.toString() + after;
    }

    static String move(String input, String operation, boolean reverse) {
        String[] splitted = operation.split(" ");
        int sourceIndex = Integer.parseInt(splitted[2]);
        int destinationIndex = Integer.parseInt(splitted[splitted.length - 1]);
        if (reverse) {
            return movePosition(input, destinationIndex, sourceIndex);
        } else {
            return movePosition(input, sourceIndex, destinationIndex);
        }
    }

    static String movePosition(String str, int sourceIndex, int destinationIndex) {
        char removedChar = str.charAt(sourceIndex);
        String stringWithoutChar = str.substring(0, sourceIndex) + str.substring(sourceIndex + 1);

        return stringWithoutChar.substring(0, destinationIndex) + removedChar
                + stringWithoutChar.substring(destinationIndex);
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day21/input.txt");
        porcessLines(lines);
        String input = "abcdefgh";
        for (String operation : operations) {
            if (operation.contains("swap")) {
                input = swap(input, operation);
            } else if (operation.contains("rotate")) {
                input = rotate(input, operation, false);
            } else if (operation.contains("reverse")) {
                input = reverseSubString(input, operation);
            } else if (operation.contains("move")) {
                input = move(input, operation, false);
            } else {
                System.out.println("Not valid operation: " + operation);
            }
        }
        System.out.println("Part 1: " + input);
        input = "fbgdceah";
        for (int i = operations.size() - 1; i >= 0; i--) {
            String operation = operations.get(i);
            if (operation.contains("swap")) {
                input = swap(input, operation);
            } else if (operation.contains("rotate")) {
                input = rotate(input, operation, true);
            } else if (operation.contains("reverse")) {
                input = reverseSubString(input, operation);
            } else if (operation.contains("move")) {
                input = move(input, operation, true);
            } else {
                System.out.println("Not valid operation: " + operation);
            }
        }
        System.out.println("Part 2: " + input);
    }
}
