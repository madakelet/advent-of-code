package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static String instructions;
    public static List<String> names = new ArrayList<>();
    public static List<String> lefts = new ArrayList<>();
    public static List<String> rights = new ArrayList<>();

    public static void main(String[] args) {
        readToNodesArray("day8/input.txt");
        boolean found = false;
        int count = 1;
        int charAt = 0;
        String stringToFind = "AAA";
        int index;
        while (!found) {
            System.out.println("Looking for: " + stringToFind);
            if (charAt == instructions.length()) {
                charAt = 0;
            }
            index = findInArray(stringToFind, names);
            System.out.println("Index of : " + stringToFind + " is at " + index);
            System.out.println("Instruction: " + instructions.charAt(charAt));
            if (instructions.charAt(charAt) == 'L') {
                System.out.println("Left is: " + lefts.get(index));
                stringToFind = lefts.get(index);
            } else if (instructions.charAt(charAt) == 'R') {
                System.out.println("Right is: " + rights.get(index));
                stringToFind = rights.get(index);
            }
            if (stringToFind.equals("ZZZ")) {
                found = true;
                System.out.println("Found it! Steps is: " + count);
                return;
            }
            count++;
            charAt++;
        }
    }

    public static void readToNodesArray(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 1;
            while ((line = br.readLine()) != null) {
                if (lineCount == 1) {
                    instructions = line;
                } else {
                    if (!line.isBlank()) {
                        String[] parts = line.trim().split("\\s*=\\s*\\(|,\\s*|\\)");
                        names.add(parts[0]);
                        lefts.add(parts[1]);
                        rights.add(parts[2]);
                    }
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findInArray(String chars, List<String> array) {
        return array.indexOf(chars);
    }

}
