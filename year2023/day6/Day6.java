package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day6 {

    public static int[] times;
    public static int[] distances;
    public static int possibleWinsMultiplied = 1;
    public static long timesConcatenated;
    public static long distancesConcatenated;
    public static long sumOfConcatenated;

    public static void main(String[] args) {
        String filePath = "year2023/day6/input.txt";
        collectInputToArray(filePath);
        calculatePossibleWins();
        System.out.println("Possible wins multiplied = " + possibleWinsMultiplied);
        timesConcatenated = concatNumbers(times);
        distancesConcatenated = concatNumbers(distances);
        System.out.println("Times concatenated = " + timesConcatenated);
        System.out.println("Distances concatenated = " + distancesConcatenated);
        calculatePartTwo();
        System.out.println("Possible wins summed = " + sumOfConcatenated);
    }

    public static void collectInputToArray(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNr = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\s+");
                if (values.length > 1) {
                    if (lineNr == 0) {
                        times = Arrays.stream(values, 1, values.length)
                                .mapToInt(Integer::parseInt)
                                .toArray();
                    } else {
                        distances = Arrays.stream(values, 1, values.length)
                                .mapToInt(Integer::parseInt)
                                .toArray();
                    }
                }
                lineNr++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculatePossibleWins() {
        int timesLength = times.length;
        for (int i = 0; i < timesLength; i++) {
            int numberOfWaysToWin = 0;
            int halfOfCurrentTime = times[i] / 2;
            int currentSpeed = 1;
            while (currentSpeed <= halfOfCurrentTime) {
                int timeRemaining = times[i] - currentSpeed;
                int distance = currentSpeed * timeRemaining;
                if (distance > distances[i]) {
                    numberOfWaysToWin += (timeRemaining == currentSpeed) ? 1 : 2;
                }
                currentSpeed++;
            }
            possibleWinsMultiplied *= numberOfWaysToWin;
        }
    }

    public static void calculatePartTwo() {
        long inner = (timesConcatenated * timesConcatenated) - (4 * distancesConcatenated);
        double rootOfInner = Math.sqrt(inner);
        double bound = Math.abs((timesConcatenated * -1 + rootOfInner) / -2);
        sumOfConcatenated = (long) (timesConcatenated - (2 * bound)) + 1;
    }

    public static long concatNumbers(int[] array) {
        StringBuilder concatenated = new StringBuilder();
        for (int number : array) {
            concatenated.append(number);
        }

        return Long.parseLong(concatenated.toString());
    }
}