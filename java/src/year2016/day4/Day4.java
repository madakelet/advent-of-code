package year2016.day4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.ReadFile;

public class Day4 {
    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day4/input.txt");
        processLines(lines);
    }

    static void processLines(String lines) {
        int sum = 0;
        for (String line : lines.split("\n")) {
            String parts[] = line.split("-");
            parts[parts.length - 1] = parts[parts.length - 1].replace("]", "");
            String room[] = parts[parts.length - 1].split("\\[");
            int roomNr = Integer.parseInt(room[0]);
            int charsToShift = roomNr % 26;
            String letters = room[1];
            // System.out.println("Room nr: " + room[0] + " letters: " + room[1]);
            Map<Character, Integer> charsCount = new HashMap<>();
            int i = 0;
            StringBuilder builder = new StringBuilder();
            for (String part : parts) {
                if (i == parts.length - 1) {
                    break;
                }
                for (char currentChar : part.toCharArray()) {
                    builder.append((char) ('a' + (currentChar - 'a' + charsToShift) % 26));
                    charsCount.put(currentChar, charsCount.getOrDefault(currentChar, 0) + 1);
                }
                builder.append(" ");
                i++;
            }
            //System.out.println(builder.toString());
            if(builder.toString().equals("northpole object storage ")) {
                System.out.println("Part 2: " + roomNr);
            }
            List<Map.Entry<Character, Integer>> sorted = sortMap(charsCount);
            // for (Map.Entry<Character, Integer> entry : sorted) {
            // System.out.println(entry.getKey() + ": " + entry.getValue());
            // }
            i = 0;
            boolean match = true;
            while(i < letters.length() && match) {
                //System.out.println("Checking " + letters.charAt(i) + " and " + sorted.get(i).getKey());
                if(letters.charAt(i) != sorted.get(i).getKey()) {
                    match = false;
                }
                i++;
            }
            if(match) sum += roomNr;
        }
        System.out.println("Part 1: " + sum);
    }

    static List<Map.Entry<Character, Integer>> sortMap(Map<Character, Integer> charsCount) {
        List<Map.Entry<Character, Integer>> sortedList = new LinkedList<>(charsCount.entrySet());
        sortedList.sort(
                (entry1, entry2) -> {
                    int result = entry2.getValue().compareTo(entry1.getValue());
                    return result != 0 ? result : entry1.getKey().compareTo(entry2.getKey());
                });
        return sortedList;
    }
}
