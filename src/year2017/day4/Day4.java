package year2017.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.ReadFile;

public class Day4 {

    static void processLines(String lines) {
        int validPhrases = 0;
        int validPartTwo = 0;
        for (String line : lines.split("\n")) {
            if (isValidPassphrase(line, true))
                validPhrases++;
            if (isValidPassphrase(line, false)) {
                validPartTwo++;
            }
        }
        System.out.println("Part 1: " + validPhrases);
        System.out.println("Part 2: " + validPartTwo);
    }

    static boolean isValidPassphrase(String passphrase, boolean partOne) {
        boolean isValid = true;
        Map<String, Integer> words = new HashMap<>();
        for (String word : passphrase.split(" ")) {
            if (partOne) {
                if (words.containsKey(word)) {
                    isValid = false;
                    break;
                } else {
                    words.put(word, 1);
                }
            } else {
                char[] wordsArray = word.toCharArray();
                Arrays.sort(wordsArray);
                word = new String(wordsArray);
                if (words.containsKey(word)) {
                    isValid = false;
                    break;
                } else {
                    words.put(word, 1);
                }
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2017/day4/input.txt");
        processLines(lines);
    }
}
