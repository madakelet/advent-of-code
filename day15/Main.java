package day15;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static List<String> strings = new ArrayList<>();
    public static void main(String[] args) {
        readToStringsArray("day15/input.txt");
        int sum = 0;
        for (String currentString : strings) {
            int currentSum = 0;
            for (char currentChar : currentString.toCharArray()) {
                currentSum = getHashValue((int) currentChar + currentSum);
            }
            sum += currentSum;
        }
        System.out.println("Sum: " + sum);
    }    

    public static void readToStringsArray(String filePath)  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] explodedStrings = line.split(",");
                for (String string : explodedStrings) {
                    strings.add(string);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHashValue(int asciiValue) {
        int value = (asciiValue * 17) % 256;
        return value;
    }
}