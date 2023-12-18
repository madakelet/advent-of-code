import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("year2023/day1/input.txt"));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                StringBuilder builder = new StringBuilder();
                Pattern pattern = Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine");
                Matcher matcher = pattern.matcher(line);
                int firstNumber = -1;
                int lastNumber = -1;
                while (matcher.find()) {
                    String match = matcher.group();
                    if (match.matches("\\d+")) {
                        int number = Integer.parseInt(match);
                        if (firstNumber == -1) {
                            firstNumber = number;
                        }
                        lastNumber = number;
                    } else {
                        int number = convertWordToNumber(match);
                        if (firstNumber == -1) {
                            firstNumber = number;
                        }
                        lastNumber = number;
                    }
                }
                builder.append(firstNumber).append(lastNumber);
                sum += Integer.parseInt(builder.toString());
                //System.out.println("Current number:" + builder.toString());
            }
            reader.close();
            System.out.println("Final sum:" + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int convertWordToNumber(String word) {
        switch (word) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                return -1; // Return -1 for unknown words
        }
    }
}
