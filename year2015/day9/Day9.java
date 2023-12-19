package year2015.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9 {
    public static Map<String, Map<String, Integer>> distances = new HashMap<>();

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day9/input.txt");
        for (String line : lines.split("\n")) {
            processLine(line);
        }
        String[] shortestPath = findShortestPath();
        int distance = pathDistance(shortestPath);
        System.out.println("The shortest path is " + Arrays.toString(shortestPath) + " in " +
                distance);
        String[] longestPath = findLongestPath();
        distance = pathDistance(longestPath);
        System.out.println("The longest path is " + Arrays.toString(longestPath) + " in " +
                distance);
    }

    static void processLine(String line) {
        String[] parts = line.split(" ");
        String from = parts[0];
        String to = parts[2];
        int distance = Integer.parseInt(parts[4]);
        if (!distances.containsKey(from)) {
            distances.put(from, new HashMap<>());
        }
        distances.get(from).put(to, distance);
        if (!distances.containsKey(to)) {
            distances.put(to, new HashMap<>());
        }
        distances.get(to).put(from, distance);
    }

    static void printDistances() {
        for (String from : distances.keySet()) {
            for (String to : distances.get(from).keySet()) {
                System.out.println(from + " -> " + to + " = " + distances.get(from).get(to));
            }
        }
    }

    static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static <T> void allPermutationsHelper(T[] permutation, List<T[]> permutations, int n) {
        if (n <= 0) {
            permutations.add(Arrays.copyOf(permutation, permutation.length));
            return;
        }
        T[] tempPermutation = Arrays.copyOf(permutation, permutation.length);
        for (int i = 0; i < n; i++) {
            swap(tempPermutation, i, n - 1);
            allPermutationsHelper(tempPermutation, permutations, n - 1);
            swap(tempPermutation, i, n - 1);
        }
    }

    static <T> List<T[]> permutations(T[] original) {
        List<T[]> permutations = new ArrayList<>();
        allPermutationsHelper(original, permutations, original.length);
        return permutations;
    }

    static int pathDistance(String[] path) {
        int distance = 0;
        for (int i = 0; i < path.length - 1; i++) {
            distance += distances.get(path[i]).get(path[i + 1]);
        }
        return distance;
    }

    static String[] findShortestPath() {
        String[] cities = distances.keySet().toArray(String[]::new);
        List<String[]> paths = permutations(cities);
        String[] shortestPath = null;
        int minDistance = Integer.MAX_VALUE;
        for (String[] path : paths) {
            int distance = pathDistance(path);
            if (distance < minDistance) {
                minDistance = distance;
                shortestPath = path;
            }
        }
        return Arrays.copyOf(shortestPath, shortestPath.length);
    }

    static String[] findLongestPath() {
        String[] cities = distances.keySet().toArray(String[]::new);
        List<String[]> paths = permutations(cities);
        String[] longestPath = null;
        int maxDistance = Integer.MIN_VALUE;
        for (String[] path : paths) {
            int distance = pathDistance(path);
            if (distance > maxDistance) {
                maxDistance = distance;
                longestPath = path;
            }
        }
        return Arrays.copyOf(longestPath, longestPath.length);
    }

}
