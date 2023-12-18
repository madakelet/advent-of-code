package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        readToArray("year2023/day9/input.txt");
        int result = 0;
        for (List<Integer> numbers : list) {
            result += getResult(numbers);
        }
        System.out.println("Final result: " + result);

        result = 0;
        for (List<Integer> numbers : list) {
            Collections.reverse(numbers);
            result += getResult(numbers);
        }
        System.out.println("Final result: " + result);
    }

    public static void readToArray(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] stringNumbers = line.split(" ");
                List<Integer> numbers = new ArrayList<>();
                for (String stringNumber : stringNumbers) {
                    numbers.add(Integer.parseInt(stringNumber));
                }
                list.add(numbers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getResult(List<Integer> numbers) {
        int sum = 0;
        while (true) {
            boolean allZero = true;
            var diffs = new ArrayList<Integer>();
            sum += numbers.get(numbers.size() - 1);
            for (int i = 0; i < numbers.size() - 1; i++) {
                int diff = numbers.get(i + 1) - numbers.get(i);
                if (diff != 0)
                    allZero = false;
                diffs.add(diff);
            }
            if (allZero)
                break;
            numbers = diffs;
        }
        return sum;
    }
}