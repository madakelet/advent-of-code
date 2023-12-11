package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static int[] times;
    public static int[] distances;
    public static int possibleWinsMultiplied = 1;

    public static void main(String[] args) {
        String filePath = "day6/input.txt";
        collectInputToArray(filePath);
        calculatePossibleWins();
        System.out.println("Possible wins multiplied = " + possibleWinsMultiplied);
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
}