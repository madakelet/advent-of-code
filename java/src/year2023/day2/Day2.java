package year2023.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("2023/day2/input.txt"));
            String line;
            int sum = 0;
            int powerSum = 0;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = Pattern.compile("Game (\\d+):").matcher(line);
                int gameNumber = matcher.find() ? Integer.parseInt(matcher.group(1)) : -1;
                Game game = new Game(gameNumber);
                game.processInput(line);
                if (game.isPossible()) {
                    sum += gameNumber;
                }
                powerSum += game.getPower();   
            }
            reader.close();
            System.out.println("Colors bigger sum: " + sum);
            System.out.println("Colors power sum: " + powerSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
