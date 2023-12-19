package year2015.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 {
    static Map<String, Map<String, Integer>> happinessMap = new HashMap<>();

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day13/input.txt");
        processLines(lines);
        List<String> people = new ArrayList<>(happinessMap.keySet());
        List<List<String>> permutations = generatePermutations(people);
        int maxHappiness = 0;   
        for (List<String> permutation : permutations) {
            int happiness = calculateHappiness(permutation);
            if (happiness > maxHappiness) {
                maxHappiness = happiness;
            }
        }
        System.out.println("Part 1: " + maxHappiness);
        addNewPerson("Me");
        people = new ArrayList<>(happinessMap.keySet());
        permutations = generatePermutations(people);
        maxHappiness = 0;
        for (List<String> permutation : permutations) {
            int happiness = calculateHappiness(permutation);
            if (happiness > maxHappiness) {
                maxHappiness = happiness;
            }
        }
        System.out.println("Part 2: " + maxHappiness);
    }

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            String[] parts = line.split(" ");
            String from = parts[0];
            String to = parts[10].substring(0, parts[10].length() - 1);
            int happiness = Integer.parseInt(parts[3]);
            if (parts[2].equals("lose")) {
                happiness *= -1;
            }
            if (!happinessMap.containsKey(from)) {
                happinessMap.put(from, new HashMap<>());
            }
            Map<String, Integer> fromMap = happinessMap.get(from);
            fromMap.put(to, fromMap.getOrDefault(to, 0) + happiness);
            if (!happinessMap.containsKey(to)) {
                happinessMap.put(to, new HashMap<>());
            }
            Map<String, Integer> toMap = happinessMap.get(to);
            toMap.put(from, toMap.getOrDefault(from, 0) + happiness);
        }
    }

    static void printHappinessMap() {
        for (String from : happinessMap.keySet()) {
            for (String to : happinessMap.get(from).keySet()) {
                System.out.println(from + " -> " + to + " = " + happinessMap.get(from).get(to));
            }
        }
    }

    static List<List<String>> generatePermutations(List<String> people) {
        List<List<String>> result = new ArrayList<>();
        permute(people.size() - 1, people, result);
        return result;
    }

    static void permute(int n, List<String> people, List<List<String>> result) {
        if (n == 1) {
            result.add(new ArrayList<>(people));
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            permute(n - 1, people, result);
            if (n % 2 == 0) {
                Collections.swap(people, i, n - 1);
            } else {
                Collections.swap(people, 0, n - 1);
            }
        }
        permute(n - 1, people, result);
    }

    static int calculateHappiness(List<String> people) {
        int happiness = 0;
        int i = 0;
        while(i < people.size()) {
            String from = people.get(i);
            String to = people.get((i + 1) % people.size());
            //System.out.println(from + " -> " + to + " = " + happinessMap.get(from).get(to));
            happiness += happinessMap.get(from).get(to);
            i++;
        }
        return happiness;
    }

    static void addNewPerson(String person) {
        for (String from : happinessMap.keySet()) {
            happinessMap.get(from).put(person, 0);
        }
        happinessMap.put(person, new HashMap<>());
        for (String to : happinessMap.keySet()) {
            happinessMap.get(person).put(to, 0);
        }
    }
}
