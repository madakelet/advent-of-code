package year2016.day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import utils.ReadFile;

public class Day23 {

    static List<String> instructions = new ArrayList<>();
    static Map<String, Integer> registers = new HashMap<>();

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            instructions.add(line);
        }
    }

    static void initRegisters(int a, int b, int c, int d) {
        registers.put("a", a);
        registers.put("b", b);
        registers.put("c", c);
        registers.put("d", d);
    }

    static void execCopy(int value, String register) {
        registers.put(register, value);
    }

    static void execInc(String register) {
        int current = registers.get(register);
        registers.put(register, current + 1);
    }

    static void execDec(String register) {
        int current = registers.get(register);
        registers.put(register, current - 1);
    }

    static int execJump(String register, String amountString) {
        int jump = 0;
        int amount;
        if (Pattern.matches("-?\\d+", amountString)) {
            amount = Integer.parseInt(amountString);
        } else {
            amount = registers.get(amountString);
        }
        if (Pattern.matches("-?\\d+", register)) {
            if (Integer.parseInt(register) != 0) {
                jump += amount - 1;
            }
        } else if (registers.get(register) != 0) {
            jump += amount - 1;
        }
        return jump;
    }

    static void doInstructions() {
        printRegisters();
        for (int i = 0; i < instructions.size(); i++) {
            // System.out.println("Executin line: " + instructions.get(i));
            String[] parts = instructions.get(i).split(" ");
            switch (parts[0]) {
                case "cpy":
                    if (Pattern.matches("-?\\d+", parts[1])) {
                        execCopy(Integer.parseInt(parts[1]), parts[2]);
                    } else {
                        execCopy(registers.get(parts[1]), parts[2]);
                    }
                    break;
                case "inc":
                    execInc(parts[1]);
                    break;
                case "dec":
                    execDec(parts[1]);
                    break;
                case "jnz":
                    i += execJump(parts[1], parts[2]);
                    break;
                case "tgl":
                    execToggle(parts[1], i);
                    break;
                default:
                    break;
            }
            printRegisters();
        }
    }

    static void execToggle(String register, int index) {
        int indexToToggle = registers.get(register) + index;
        if (indexToToggle >= registers.size())
            return;
        String instructionToToggle = instructions.get(indexToToggle);
        String[] instuctionSplitted = instructionToToggle.split(" ");
        if (instuctionSplitted.length == 2) {
            if (instuctionSplitted[0].equals("inc")) {
                String newInstruction = instructionToToggle.replace("inc", "dec");
                instructions.add(indexToToggle, newInstruction);
            } else {
                String newInstruction = instructionToToggle.replace("dec", "inc");
                newInstruction = newInstruction.replace("tgl", "inc");
                newInstruction = newInstruction.replace("cpy", "inc");
                newInstruction = newInstruction.replace("jnz", "inc");
            }
        }
    }

    static void printRegisters() {
        System.out.print("[ ");
        for (Map.Entry<String, Integer> register : registers.entrySet()) {
            System.out.print(register.getKey() + ": " + register.getValue() + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day23/input.txt");
        processLines(lines);
        initRegisters(7, 0, 0, 0);
        doInstructions();
    }
}
