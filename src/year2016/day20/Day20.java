package year2016.day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ReadFile;

public class Day20 {
    static List<Long> mins = new ArrayList<>();
    static List<Long> maxes = new ArrayList<>();

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            long min = Long.parseLong(line.split("-")[0]);
            long max = Long.parseLong(line.split("-")[1]);
            mins.add(min);
            maxes.add(max);
        }
    }

    static void findSmallestIp(int index) {
        //System.out.println("checking: " + mins.get(index) + "-" + maxes.get(index));
        long min = mins.get(index);
        long max = maxes.get(index);
        boolean found = false;
        int i = 0;
        while (i < mins.size() && !found) {
            if (max > mins.get(i) && max < maxes.get(i)) {
                found = true;
            } else if (mins.get(i) == max + 1) {
                found = true;
            } else {
                i++;
            }
        }
        if(found) {
            //System.out.println("found: " + mins.get(i) + "-" + maxes.get(i));
            findSmallestIp(i);
        } else {
            System.out.println("Part 1: " + mins.get(index) + "-" + maxes.get(index));
        }
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day20/input.txt");
        processLines(lines);
        int smallestIndex = mins.indexOf(Collections.min(mins));
        findSmallestIp(smallestIndex);
    }
}
