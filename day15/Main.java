package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Main {

    public static List<String> strings = new ArrayList<>();
    public static Map<Integer, Map<String, Integer>> boxesMap = new HashMap<>();

    public static void main(String[] args) {
        readToStringsArray("day15/input.txt");
        int sum = 0;
        for (String currentString : strings) {
            processLabel(currentString);
            sum += getHashValue(currentString);
        }
        System.out.println("Sum: " + sum);
        sum = 0;
        for (Map.Entry<Integer, Map<String, Integer>> entry : boxesMap.entrySet()) {
            int boxNumber = entry.getKey() + 1;
            int place = 1;
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                sum = sum + (boxNumber * place * innerEntry.getValue()); 
                place++;
            }
            
        }
        System.out.println("Sum 2: " + sum);
    }

    public static void readToStringsArray(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] explodedStrings = line.split(",");
                for (String string : explodedStrings) {
                    strings.add(string);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHashValue(String string) {
        int value = 0;
        for (char currentChar : string.toCharArray()) {
            int asciiValue = (int) currentChar;
            value += asciiValue;
            value *= 17;
            value %= 256;
        }
        return value;
    }

    public static void processLabel(String string) {
        if (string.indexOf("-") != -1) {
            processDash(string);
        } else {
            processEqual(string);
        }
        // System.out.println("String: " + string);
        // printBoxes();
    }

    public static void processDash(String string) {
        String[] exploded = string.split("-");
        String label = exploded[0];
        int boxNumber = getHashValue(label);
        if (boxesMap.containsKey(boxNumber)) {
            processExistingBoxDash(boxesMap.get(boxNumber), exploded);
        } else {
            return;
        }
    }

    public static void processEqual(String string) {
        String[] exploded = string.split("=");
        String label = exploded[0];
        int focalLength = Integer.parseInt(exploded[1]);
        int boxNumber = getHashValue(label);
        if (!boxesMap.containsKey(boxNumber)) {
            Map<String, Integer> box = new LinkedHashMap<>();
            box.put(label, focalLength);
            boxesMap.put(boxNumber, box);
        } else {
            processExistingBoxEquals(boxesMap.get(boxNumber), label, focalLength);
        }
    }

    public static void processExistingBoxEquals(Map<String, Integer> box, String label, int focalLength) {
        box.put(label, focalLength);
    }

    public static void processExistingBoxDash(Map<String, Integer> box, String[] exploded) {
        String label = exploded[0];
        if (box.containsKey(label)) {
            box.remove(label);
            if(box.isEmpty()) {
                boxesMap.remove(getHashValue(label));
            }
        } else {
            return;
        }
    }

    public static void printBoxes() {
        for (Map.Entry<Integer, Map<String, Integer>> entry : boxesMap.entrySet()) {
            System.out.println("Box: " + entry.getKey());
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                System.out.print("[" + innerEntry.getKey() + " " + innerEntry.getValue() + "] ");
            }
            System.out.println();
        }
        System.out.println("==================================");
    }
}