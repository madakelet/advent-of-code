package year2016.day22;

import java.util.ArrayList;
import java.util.List;

import utils.ReadFile;

public class Day22 {
    static List<Node> nodes = new ArrayList<>();

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            line = line.trim();
            line = line.replaceAll("\\s+", " ");
            String[] splitted = line.split(" ");
            int size = getInteger(splitted[1]);
            int used = getInteger(splitted[2]);
            int avail = getInteger(splitted[3]);
            int percent = getInteger(splitted[4]);
            int x = getPoint(splitted[0], "x");
            int y = getPoint(splitted[0], "y");
            Node node = new Node(x, y, size, used, avail, percent);
            nodes.add(node);
        }
    }

    static int getInteger(String input) {
        return Integer.parseInt(input.substring(0, input.length() - 1));
    }

    static int getPoint(String input, String axis) {
        String[] splitted = input.split("-");
        if (axis.equals("x")) {
            return Integer.parseInt(splitted[1].substring(1, splitted[1].length()));
        } else {
            return Integer.parseInt(splitted[2].substring(1, splitted[2].length()));
        }
    }

    static void calculateViablePairs() {
        int count = 0;
        for(int i = 0; i < nodes.size() - 1; i++) {
            Node nodeA = nodes.get(i);
            for(int j = i + 1; j < nodes.size(); j++)  {
                Node nodeB = nodes.get(j);
                if(nodeB.isVailablePair(nodeA)) count++;
                if(nodeA.isVailablePair(nodeB)) count++;
            }
        }
        System.out.println("Viable pairs: " + count);
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day22/input.txt");
        processLines(lines);
        calculateViablePairs();
    }
}
