package year2015.day7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day7 {
    static String lines;
    static Map<String, String> instructions = new HashMap<>();
    static Map<String, Character> wires = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        lines = utils.ReadFile.readFromFile("year2015/day7/input.txt");
        for (String line : lines.split("\n")) {
            processLine(line);
        }
        findValue("a");
        String key = "a";
        int result = (int) wires.get(key);
        System.out.println(key + ": " + result);
    }

    static void processLine(String line) {
        String[] splitByArrow = line.split(" -> ");
        String wire = splitByArrow[1];
        String[] parts = splitByArrow[0].split(" ");
        String instruction = null;
        switch (parts.length) {
            case 1:
                instruction = "SET" + " " + parts[0];
                break;
            case 2:
                instruction = parts[0] + " " + parts[1];
                break;
            case 3:
                instruction = parts[1] + " " + parts[0] + " " + parts[2];
                break;
        }
        instructions.put(wire, instruction);
    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    static void findValue(String wire) {
        String instruction = instructions.get(wire);
        String[] instructionParts = instruction.split(" ");
        Character arg1, arg2, result = null;
        switch (instructionParts[0]) {
            case "SET":
                if (isInteger(instructionParts[1])) {
                    arg1 = (char) Integer.parseInt(instructionParts[1]);
                } else {
                    if ((wires.get(instructionParts[1])) == null) {
                        findValue(instructionParts[1]);
                    }
                    arg1 = wires.get(instructionParts[1]);
                }
                wires.put(wire, calculateOperation("SET", arg1, null));
                break;
            case "NOT":
                if ((wires.get(instructionParts[1])) == null) {
                    findValue(instructionParts[1]);
                }
                arg1 = wires.get(instructionParts[1]);
                result = calculateOperation("NOT", arg1, null);
                wires.put(wire, result);
                break;
            case "AND":
                if (isInteger(instructionParts[1])) {
                    arg1 = (char) Integer.parseInt(instructionParts[1]);
                } else {
                    if ((wires.get(instructionParts[1])) == null) {
                        findValue(instructionParts[1]);
                    }
                    arg1 = wires.get(instructionParts[1]);
                }
                if ((wires.get(instructionParts[2])) == null) {
                    findValue(instructionParts[2]);
                }
                arg2 = wires.get(instructionParts[2]);
                result = calculateOperation("AND", arg1, arg2);
                wires.put(wire, result);
                break;
            case "OR":
                if ((wires.get(instructionParts[1])) == null) {
                    findValue(instructionParts[1]);
                }
                arg1 = wires.get(instructionParts[1]);
                if ((wires.get(instructionParts[2])) == null) {
                    findValue(instructionParts[2]);
                }
                arg2 = wires.get(instructionParts[2]);
                result = calculateOperation("OR", arg1, arg2);
                wires.put(wire, result);
                break;
            case "LSHIFT":
                if ((wires.get(instructionParts[1])) == null) {
                    findValue(instructionParts[1]);
                }
                arg1 = wires.get(instructionParts[1]);
                arg2 = (char) Integer.parseInt(instructionParts[2]);
                result = calculateOperation("LSHIFT", arg1, arg2);
                wires.put(wire, result);
                break;
            case "RSHIFT":
                if ((wires.get(instructionParts[1])) == null) {
                    findValue(instructionParts[1]);
                }
                arg1 = wires.get(instructionParts[1]);
                arg2 = (char) Integer.parseInt(instructionParts[2]);
                result = calculateOperation("RSHIFT", arg1, arg2);
                wires.put(wire, result);
                break;
        }
    }

    static char calculateOperation(String operation, Character x, Character y) {
        switch (operation) {
            case "SET":
                return x;
            case "NOT":
                return (char) (~x);
            case "AND":
                return (char) (x & y);
            case "OR":
                return (char) (x | y);
            case "LSHIFT":
                return (char) (x << y);
            case "RSHIFT":
                return (char) (x >>> y);
        }
        return (char) -1;
    }

}