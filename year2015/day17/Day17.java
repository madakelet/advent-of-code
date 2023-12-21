package year2015.day17;

import java.util.ArrayList;
import java.util.List;

public class Day17 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day17/input.txt");
        List<Integer> containers = new ArrayList<>();
        for(String line: lines.split("\n")) {
            containers.add(Integer.parseInt(line));
        }
        int combinations = 0;
        for(int i = 0; i < Math.pow(2, containers.size()); i++) {
            int sum = 0;
            for(int j = 0; j < containers.size(); j++) {
                if((i & (1 << j)) > 0) {
                    sum += containers.get(j);
                }
            }
            if(sum == 150) {
                combinations++;
            }
        }

        System.out.println("Combinations: " + combinations);
    }
}
