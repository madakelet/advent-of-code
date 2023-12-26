package year2023.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {

    public static List<Long> numbersToFind = new ArrayList<>();

    public static void main(String[] args) {
        readFromInput("year2023/day5/input.txt");
        System.out.println(Collections.min(numbersToFind));
    }

    public static void readFromInput(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNr = 1;
            while ((line = br.readLine()) != null) {
                if (lineNr == 1) {
                    addFirstLineToArray(line);
                    br.readLine();
                } else {
                    List<Range> currentRanges = readMap(br);
                    for(int i = 0; i < numbersToFind.size(); i++) {
                        for (Range range : currentRanges) {
                            if (numbersToFind.get(i) >= range.start && numbersToFind.get(i) <= range.end) {
                                numbersToFind.set(i, numbersToFind.get(i) + range.distance);
                                break;
                            }
                        }
                    }
                }
                lineNr++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addFirstLineToArray(String line) {
        String subString = line.substring(7);
        String[] split = subString.split(" ");
        for (String string : split) {
            numbersToFind.add(Long.parseLong(string));
        }
    }

    private static List<Range> readMap(BufferedReader reader) throws IOException {
        List<Range> ranges = new ArrayList<>(); 
        String line;
        while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
            String[] values = line.trim().split(" ");
            long destination = Long.parseLong(values[0]);
            long start = Long.parseLong(values[1]);
            long length = Long.parseLong(values[2]);
            Range range = new Range(destination, start, length);
            ranges.add(range);
        }
        return ranges;
    }
}