package year2016.day9;

import utils.ReadFile;

public class Day9 {
    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day9/input.txt");
        processLines(lines);
    }

    static void processLines(String lines) {
        int sum = 0;
        for (String line : lines.split("\n")) {
            String currentDecompressedLine = decompressLine(line);
            sum += currentDecompressedLine.length();
        }
        System.out.println("Part 1: " + sum);
    }

    static String decompressLine(String line) {
        StringBuilder decompressedString = new StringBuilder();
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) != '(') {
                decompressedString.append(line.charAt(i));
                i++;
            } else {
                i++;
                String numbers = findNumbers(i, line);
                i = closingParenthesis(i, line);
                i++;
                int length = Integer.parseInt(numbers.split("x")[0]);
                int repeat = Integer.parseInt(numbers.split("x")[1]);
                String stringToRepeat = line.substring(i, i + length);
                for (int j = 0; j < repeat; j++) {
                    decompressedString.append(stringToRepeat);
                }
                i = i + length;
            }
        }

        return decompressedString.toString();
    }

    static String findNumbers(int i, String line) {
        boolean closedParenthesis = false;
        StringBuilder insideParenthesis = new StringBuilder();

        while (i < line.length() && !closedParenthesis) {
            if (line.charAt(i) != ')') {
                insideParenthesis.append(line.charAt(i));
            } else {
                closedParenthesis = true;
            }
            i++;
        }
        return insideParenthesis.toString();
    }

    static int closingParenthesis(int i, String line) {
        while (i < line.length()) {
            if (line.charAt(i) == ')')
                break;
            i++;
        }
        return i;
    }
}
