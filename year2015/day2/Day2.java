package year2015.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void main(String[] args) {
        String filePath = "year2015/day2/input.txt";
        String lines = readFromFile(filePath);
        int sum = 0;
        for(String line : lines.split("\n")) {
            String[] dimensions = line.split("x");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);
            int area = 2*l*w + 2*w*h + 2*h*l;
            int slack = Math.min(Math.min(l*w, w*h), h*l);
            sum += area + slack;
            System.out.println("Dimensions: " + l + "x" + w + "x" + h + " Area: " + area + " Slack: " + slack);
        }
        System.out.println("Part 1: " + sum);
    }

    public static String readFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
