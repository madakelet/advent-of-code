package year2015.day14;

import java.util.ArrayList;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day14/input.txt");
        List<Reindeer> reindeers = new ArrayList<>();
        for (String line : lines.split("\n")) {
            Reindeer reindeer = processLine(line);
            reindeers.add(reindeer);
        }
        System.out.println("Part 1: "
                + reindeers.stream().mapToInt(reindeer -> calculateDistance(reindeer, 2503)).max().getAsInt());

        System.out.println("Part 2: " + part2(reindeers));
    }

    static Reindeer processLine(String line) {
        String[] parts = line.split(" ");
        String name = parts[0];
        String speed = parts[3];
        String flyTime = parts[6];
        String reString = parts[13];
        Reindeer reindeer = new Reindeer(Integer.parseInt(speed), Integer.parseInt(flyTime), Integer.parseInt(reString),
                name);
        return reindeer;
    }

    static int calculateDistance(Reindeer reindeer, int time) {
        int currentTime = time;
        int distance = 0;
        while (currentTime > 0) {
            if (currentTime > reindeer.flyTime) {
                distance += reindeer.speed * reindeer.flyTime;
                currentTime -= reindeer.flyTime + reindeer.restTime;
            } else {
                distance += reindeer.speed * currentTime;
                currentTime = 0;
            }
        }
        return distance;
    }


    static int part2(List<Reindeer> reindeers) {
        int[] points = new int[reindeers.size()];
        for (int i = 0; i < 2503; i++) {
            int maxDistance = 0;
            for (int j = 0; j < reindeers.size(); j++) {
                Reindeer reindeer = reindeers.get(j);
                int distance = calculateDistance(reindeer, i + 1);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
            for (int j = 0; j < reindeers.size(); j++) {
                Reindeer reindeer = reindeers.get(j);
                int distance = calculateDistance(reindeer, i + 1);
                if (distance == maxDistance) {
                    points[j]++;
                }
            }
        }
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] > maxPoints) {
                maxPoints = points[i];
            }
        }
        return maxPoints;
    }
}
