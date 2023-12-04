package day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card {
    private int cardNr;
    private int[] leftPart;
    private int[] rightPart;
    private double winningNumberMatches = 0;

    public Card(String input) {
        splitCard(input);
    }

    private void splitCard(String input) {
        Pattern pattern = Pattern.compile("Card\\s*(\\d+):\\s*([\\d\\s]+)\\s*\\|\\s*([\\d\\s]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String cardNumber = matcher.group(1);
            int[] leftPart = parseNumbers(matcher.group(2).trim());
            int[] rightPart = parseNumbers(matcher.group(3).trim());
            this.cardNr = Integer.parseInt(cardNumber);
            this.leftPart = leftPart;
            this.rightPart = rightPart;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public void calculateWinningNumberMatches() {
        for (int myNumber : leftPart) {
            int i = 0;
            boolean found = false;
            while (i < rightPart.length && myNumber != rightPart[i]) {
                i++;
            }
            if (i < rightPart.length) {
                found = true;
            }
            if (found) {
                this.winningNumberMatches++;
            }
        }
    }

    public double getPowerOfTwo() {
        calculateWinningNumberMatches();
        return this.winningNumberMatches > 0 ? Math.pow(2, this.winningNumberMatches - 1) : 0;
    }

    private int[] parseNumbers(String input) {
        return Pattern.compile("\\s+")
                .splitAsStream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
