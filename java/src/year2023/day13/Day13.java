package year2023.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Day13 {
    public static List<Pattern> patterns = new ArrayList<>();

    public static void main(String[] args) {
        createPatternsArray("year2023/day13/input.txt");
    }

    public static void createPatternsArray(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int elementNr = 1;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    sb.append(line).append('\n');
                } else {
                    Pattern pattern = new Pattern(sb.toString());
                    patterns.add(pattern);
                    sb = new StringBuilder();
                    sum += pattern.sumPoints;
                    System.out.println("Element nr: " + elementNr);
                    System.out.println("--------------------");
                }
                elementNr++;
            }
            Pattern pattern = new Pattern(sb.toString());
            patterns.add(pattern);
            sum += pattern.sumPoints;
            System.out.println("Total sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
