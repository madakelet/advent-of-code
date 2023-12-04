package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] lines = readInputFromFile("day3/input.txt");
        EngineFixer engineFixer = new EngineFixer(lines);
        engineFixer.sumAdjecents();
    }

    private static String[] readInputFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
