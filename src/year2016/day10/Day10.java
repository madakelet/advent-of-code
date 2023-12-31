package year2016.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ReadFile;

public class Day10 {
    static Map<String, List<Integer>> bots = new HashMap<>();
    static Map<String, String> instructions = new HashMap<>();
    static Map<String, Integer> outputs = new HashMap<>();

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2016/day10/input.txt");
        processLines(lines);
        startIntructions();
        partOne();
        partTwo();
    }

    static void processLines(String lines) {
        for (String line : lines.split("\n")) {
            if (line.contains("value")) {
                String[] splittedLine = line.split(" ");
                int value = Integer.parseInt(splittedLine[1]);
                String botNumber = splittedLine[splittedLine.length - 1];
                addBotValue(botNumber, value);
            } else {
                addInstruction(line);
            }
        }
    }

    static void addBotValue(String botNumber, int value) {
        if (bots.containsKey(botNumber)) {
            bots.get(botNumber).add(value);
        } else {
            List<Integer> botValues = new ArrayList<>();
            botValues.add(value);
            bots.put(botNumber, botValues);
        }
    }

    static void printBots() {
        for (Map.Entry<String, List<Integer>> bot : bots.entrySet()) {
            System.out.print("Bot " + bot.getKey() + ": ");
            bot.getValue().forEach(value -> System.out.print(value + ", "));
            System.out.println();
        }
    }

    static void addInstruction(String line) {
        String botNumber = line.split(" ")[1];
        instructions.put(botNumber, line);
    }

    static void printInstructions() {
        for (Map.Entry<String, String> instruction : instructions.entrySet()) {
            System.out.println("Bot " + instruction.getKey() + ": " + instruction.getValue());
        }
    }

    static void startIntructions() {
        String botWithTwoInstructions = "";
        for (Map.Entry<String, List<Integer>> bot : bots.entrySet()) {
            if (bot.getValue().size() == 2) {
                botWithTwoInstructions = bot.getKey();
            }
        }
        doInstruction(botWithTwoInstructions);
    }

    static void doInstruction(String botNumber) {
        String[] instructionSplit = instructions.get(botNumber).split(" ");
        List<Integer> botValues = bots.get(botNumber);
        int low = botValues.get(0);
        int high = botValues.get(1);
        if (low > high) {
            int temp = low;
            low = high;
            high = temp;
        }

        // give low
        String giveLowNumber = instructionSplit[6];
        if (instructionSplit[5].equals("bot")) {
            giveToBot(giveLowNumber, low);
        } else if (instructionSplit[5].equals("output")) {
            giveToOutput(giveLowNumber, low);
        }
        // give high
        String giveHighNumber = instructionSplit[instructionSplit.length - 1];
        if (instructionSplit[instructionSplit.length - 2].equals("bot")) {
            giveToBot(giveHighNumber, high);
        } else if (instructionSplit[instructionSplit.length - 2].equals("output")) {
            giveToOutput(giveHighNumber, high);
        }
    }

    static void giveToBot(String botNumber, int value) {
        addBotValue(botNumber, value);
        List<Integer> botValues = bots.get(botNumber);
        if (botValues.size() == 2) {
            doInstruction(botNumber);
        }
    }

    static void giveToOutput(String outputNumber, int value) {
        outputs.put(outputNumber, value);
    }

    static void partOne() {
        List<Integer> toFind = new ArrayList<>();
        toFind.add(61);
        toFind.add(17);
        for(Map.Entry<String, List<Integer>> bot : bots.entrySet()) {
            if(toFind.containsAll(bot.getValue())) {
                System.out.println("Part 1: " + bot.getKey());
            }
        }
    }

    static void partTwo() {
        int sum = outputs.get("0") * outputs.get("1") * outputs.get("2");
        System.out.println("Part 2: " + sum);
    }
}
