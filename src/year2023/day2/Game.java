package year2023.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private int gameNr;
    private List<Round> rounds;
    private final int REDCUBES = 12;
    private final int GREENCUBES = 13;
    private final int BLUECUBES = 14;

    public Game(int gameNumber) {
        this.gameNr = gameNumber;
        this.rounds = new ArrayList<>();
    }

    public void addRound(int number, String color) {
        rounds.add(new Round(number, color));
    }

    public void processInput(String input) {
        String[] roundStrings = input.split(";");

        for (String roundString : roundStrings) {
            roundString = roundString.trim();
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\w+)").matcher(roundString);

            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group(1));
                String color = matcher.group(2);
                addRound(number, color);
            }
        }
    }

    public boolean isPossible() {
        System.out.println("Game Number: " + gameNr);
        boolean possible = true;
        int i = 0;
        while (possible && i < rounds.size()) {
            Round round = rounds.get(i);
            if (round.getColor().equals("red") && round.getNumber() > REDCUBES) {
                System.out.println("Failed at " + round.getColor() + " : " + round.getNumber());
                possible = false;
            } else if (round.getColor().equals("blue") && round.getNumber() > BLUECUBES) {
                System.out.println("Failed at " + round.getColor() + " : " + round.getNumber());
                possible = false;
            } else if (round.getColor().equals("green") && round.getNumber() > GREENCUBES) {
                System.out.println("Failed at " + round.getColor() + " : " + round.getNumber());
                possible = false;
            }
            i++;
        }
        return possible;
    }

    public int getPower() {
        int greenMax = 0;
        int redMax = 0;
        int blueMax = 0;
        for (int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            if (round.getColor().equals("red") && round.getNumber() > redMax) {
                redMax = round.getNumber();
            } else if (round.getColor().equals("blue") && round.getNumber() > blueMax) {
                blueMax = round.getNumber();
            } else if (round.getColor().equals("green") && round.getNumber() > greenMax) {
                greenMax = round.getNumber();
            }
        }
        return greenMax * blueMax * redMax;
    }

    private static class Round {
        private int number;
        private String color;

        public Round(int number, String color) {
            this.number = number;
            this.color = color;
        }

        public int getNumber() {
            return number;
        }

        public String getColor() {
            return color;
        }
    }
}
