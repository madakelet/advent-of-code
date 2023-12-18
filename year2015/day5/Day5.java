package year2015.day5;

public class Day5 {
    public static void main(String[] args) {
        String input = "year2015/day5/input.txt";
        String lines = utils.ReadFile.readFromFile(input);
        int niceStrings = 0;
        int niceStrings2 = 0;
        for (String line : lines.split("\n")) {
            if (isNice(line)) {
                niceStrings++;
            }
            if(isNice2(line)) {
                niceStrings2++;
            }
        }
        System.out.println("Part 1: " + niceStrings);
        System.out.println("Part 2: " + niceStrings2);
    }

    public static boolean isNice(String input) {
        int vowels = 0;
        boolean hasDouble = false;
        boolean hasBad = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                vowels++;
            }
            if (i > 0 && c == input.charAt(i - 1)) {
                hasDouble = true;
            }
            if (i > 0 && "ab cd pq xy".indexOf(input.substring(i - 1, i + 1)) != -1) {
                hasBad = true;
            }
        }
        return vowels >= 3 && hasDouble && !hasBad;
    }

    public static boolean isNice2(String input) {
        boolean hasPair = false;
        boolean hasRepeat = false;
        for (int i = 0; i < input.length() - 2; i++) {
            String pair = input.substring(i, i + 2);
            if (input.indexOf(pair, i + 2) != -1) {
                hasPair = true;
            }
            if (input.charAt(i) == input.charAt(i + 2)) {
                hasRepeat = true;
            }
        }
        return hasPair && hasRepeat;
    }   
}
