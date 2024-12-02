package year2015.day19;

import java.util.HashMap;
import java.util.Map;

public class Day19 {
    static Map<String, String> replacements = new HashMap<>();
    static Map<String, Integer> molecules = new HashMap<>();
    static String molecule;

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day19/input.txt");
        processLines(lines);
        calculateMolecules();
        System.out.println(molecules.size());
    }

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            if (line.contains("=>")) {
                String[] parts = line.split(" => ");
                replacements.put(parts[1], parts[0]);
            } else if (line.length() > 0) {
                molecule = line;
            }
        }
    }

    static void calculateMolecules() {
        for (String key : replacements.keySet()) {
            System.out.println(key + "=>" + replacements.get(key));
            int index = molecule.indexOf(replacements.get(key));
            while (index != -1) {
                String newString = molecule.substring(0, index) + key + molecule.substring(index + replacements.get(key).length());
                molecules.put(newString, 1);
                index = molecule.indexOf(replacements.get(key), index + 1);
            }
        }
    }
}
