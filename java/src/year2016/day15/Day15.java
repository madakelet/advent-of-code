package year2016.day15;

import java.util.List;
import java.util.ArrayList;

import utils.ReadFile;

public class Day15 {
    static List<Disc> discs = new ArrayList<>();

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            line = line.replace("#", "");
            line = line.replace(".", "");
            String[] splitted = line.split(" ");
            int discNr = Integer.parseInt(splitted[1]);
            int positions = Integer.parseInt(splitted[3]);
            int startPosition = Integer.parseInt(splitted[splitted.length - 1]);
            Disc disc = new Disc(positions, startPosition, discNr);
            discs.add(disc);
        }
    }

    static int positionAtTime(Disc disc, int currentTime) {
        return (currentTime + disc.startPosition) % disc.positions;
    }

    static int allSet() {
        int time = 0;
        boolean allSet = false;
        while (!allSet) {
            int totalPositionNumbers = 0;
            for (int i = 0; i < discs.size(); i++) {
                totalPositionNumbers += positionAtTime(discs.get(i), time + discs.get(i).discNr);
            }
            if (totalPositionNumbers == 0)
                break;
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day15/input.txt");
        processLines(lines);
        System.out.println("Part 1 Start at: " + allSet());
        Disc disc = new Disc(11, 0, discs.size() + 1);
        discs.add(disc);
        System.out.println("Part 2 Start at: " + allSet());
    }
}
