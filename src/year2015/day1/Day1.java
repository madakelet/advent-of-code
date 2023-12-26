package year2015.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) {
        String input = readFile("src/year2015/day1/input.txt");
        int floor = 0;
        int counter = 1;
        for(char c : input.toCharArray()) {
            if(c == '(') {
                floor++;
            } else if(c == ')') {
                floor--;
            }
            if(floor == -1) {
                System.out.println("First basement: " + counter);
            }
            counter++;
        }
        System.out.println("Floor: " + floor);
        System.out.println("Enter basement: " + counter);
    }

    public static String readFile(String filePath) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
