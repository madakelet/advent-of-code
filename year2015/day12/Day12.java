package year2015.day12;

public class Day12 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day12/input.txt");
        String[] splitLines = lines.split("\n");
        String line = splitLines[0];
        int part1 = removeNotNumbersAndDash(line);
        System.out.println("Part 1: " + part1);

    }   

    static int sumNumbers(String line) {
        int sum = 0;
        int i = 0;
        while (i < line.length()) {
            if (Character.isDigit(line.charAt(i)) || (line.charAt(i) == '-' && i + 1 < line.length() && Character.isDigit(line.charAt(i + 1)))) {
                int start = i;
                while (i < line.length() && Character.isDigit(line.charAt(i)) || (line.charAt(i) == '-' && i + 1 < line.length() && Character.isDigit(line.charAt(i + 1)))) {
                    i++;
                }
                sum += Integer.parseInt(line.substring(start, i));
            }
            i++;
        }
        return sum;
    }

    static int removeNotNumbersAndDash(String string) {
        string = string.replaceAll("[^0-9-]", ",");
        String[] splitString = string.split(",");
        int sum = 0;
        for (String s : splitString) {
            if (!s.equals("")) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }
    
}
