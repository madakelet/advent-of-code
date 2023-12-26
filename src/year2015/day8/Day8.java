package year2015.day8;

public class Day8 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day8/input.txt");
        String[] instructions = lines.split("\n");
        int count = 0;
        int count2 = 0;
        for (String line : instructions) {
            count += line.length() - decode(line);
            count2 += encode(line) - line.length();
        }
        System.out.println("Part 1: " + count);
        System.out.println("Part 2: " + count2);
    }

    public static int decode(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\\')
                if (line.charAt(i + 1) == 'x')
                    i += 3;
                else if (line.charAt(i + 1) == '\\' || line.charAt(i + 1) == '\"')
                    i++;
            count++;
        }
        return count - 2;
    }

    public static int encode(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\\') {
                if (line.charAt(i + 1) == '\"') {
                    count += 3;
                    i++;
                } else {
                    count++;
                }
            }
            if (line.charAt(i) == '\"') {
                count += 2;
            }
            count++;
        }
        return count;
    }
}
