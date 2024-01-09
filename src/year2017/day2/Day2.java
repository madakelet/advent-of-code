package year2017.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ReadFile;

public class Day2 {

    static void processLines(String lines) {
        int sum = 0;
        int divisibleSum = 0;
        for (String line : lines.split("\n")) {
            line = line.trim();
            line = line.replaceAll("\\s+", " ");
            String[] numbers = line.split(" ");
            sum += getCheckSum(numbers);
            divisibleSum += getEvenlyDivisibleValue(numbers);
        }
        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + divisibleSum);
    }

    static int getCheckSum(String[] numbersString) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersString) {
            numbers.add(Integer.parseInt(number));
        }
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        return max - min;
    }

    static int getEvenlyDivisibleValue(String[] numbersString) {
        int value = 0;
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersString) {
            numbers.add(Integer.parseInt(number));
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (i != j) {
                    int currentA = numbers.get(i);
                    int currentB = numbers.get(j);
                    if(currentA % currentB == 0) {
                        value = currentA / currentB;
                    } else if(currentB % currentA == 0) {
                        value = currentB / currentA;
                    }

                }
            }
        }

        return value;
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2017/day2/input.txt");
        processLines(lines);
    }
}
