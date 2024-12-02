package year2017.day1;

import utils.ReadFile;

public class Day1 {

    static int countNumbers(String input, boolean partOne) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            char next;
            if (partOne)
                next = input.charAt((i + 1) % input.length());
            else
                next = input.charAt((i + (input.length() / 2)) % input.length());
            if (current == next) {
                sum += Character.getNumericValue(current);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String input = ReadFile.readFromFile("src/year2017/day1/input.txt");
        input = input.trim();
        System.out.println("Part 1: " + countNumbers(input, true));
        System.out.println("Part 2: " + countNumbers(input, false));
    }
}
