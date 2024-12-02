package year2015.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {
    static List<Ingredient> ingredients = new ArrayList<>();

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day15/test.txt");
        for (String line : lines.split("\n")) {
            processLine(line);
        }
        int targetSum = 100;
        int numItems = ingredients.size();
        List<List<Integer>> combinations = findCombinations(targetSum, numItems);
        for(List<Integer> combination : combinations) {
            calculateTotal(combination, ingredients);
            
        }
    }

    static void processLine(String line) {
        String[] parts = line.split(" ");
        String name = parts[0].substring(0, parts[0].length() - 1);
        int capacity = Integer.parseInt(parts[2].substring(0, parts[2].length() - 1));
        int durability = Integer.parseInt(parts[4].substring(0, parts[4].length() - 1));
        int flavor = Integer.parseInt(parts[6].substring(0, parts[6].length() - 1));
        int texture = Integer.parseInt(parts[8].substring(0, parts[8].length() - 1));
        int calories = Integer.parseInt(parts[10]);
        Ingredient ingredient = new Ingredient(name, capacity, durability, flavor, texture, calories);
        ingredients.add(ingredient);
    }

    public static List<List<Integer>> findCombinations(int targetSum, int numItems) {
        List<List<Integer>> combinations = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();
        findCombinationsHelper(targetSum, numItems, new ArrayList<>(), combinations, memo);
        return combinations;
    }

    private static void findCombinationsHelper(int targetSum, int numItems, List<Integer> currentCombination,
            List<List<Integer>> combinations, Map<String, Boolean> memo) {
        if (numItems == 0) {
            int[] sortedCombination = currentCombination.stream().mapToInt(Integer::intValue).sorted().toArray();
            List<Integer> sortedList = Arrays.asList(Arrays.stream(sortedCombination).boxed().toArray(Integer[]::new));
            String key = sortedList.toString();

            if (!memo.containsKey(key)) {
                combinations.add(sortedList);
                memo.put(key, true);
            }

            return;
        }

        for (int i = 1; i <= targetSum; i++) {
            currentCombination.add(i);
            findCombinationsHelper(targetSum - i, numItems - 1, currentCombination, combinations, memo);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    static int calculateTotal(List<Integer> amounts, List<Ingredient> ingredients) {
        int total = 1;
        int totalCapacity = 0;
        int totalDurability = 0;
        int totalFlavor = 0;
        int totalTexture = 0;
        for (int i = 0; i < amounts.size(); i++) {
            totalCapacity += amounts.get(i) * ingredients.get(i).capacity;
            totalDurability += amounts.get(i) * ingredients.get(i).durability;
            totalFlavor += amounts.get(i) * ingredients.get(i).flavor;
            totalTexture += amounts.get(i) * ingredients.get(i).texture;
            System.out.print("cap: " + totalCapacity + " dur: " + totalDurability + " flav: " + totalFlavor);
            System.out.println();
        }
        if (totalCapacity < 0 || totalDurability < 0 || totalFlavor < 0 || totalTexture < 0) {
            return 0;
        }
        total = totalCapacity * totalDurability * totalFlavor * totalTexture;
        System.out.println(Arrays.toString(amounts.toArray()) + " " + total);
        return total;
    }
}
