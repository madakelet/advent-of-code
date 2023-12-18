package day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineFixer {
    private String[] lines;
    private int sum = 0;

    EngineFixer(String[] lines) {
        this.lines = lines;
    }

    public void sumAdjecents() {
        for (int i = 0; i < lines.length; i++) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(lines[i]);
            while (matcher.find()) {
                String number = matcher.group();
                boolean isOnlyDot;
                int start = matcher.start() == 0 ? 0 : matcher.start() - 1;
                int end = matcher.end() == lines[i].length() ? lines[i].length() - 1 : matcher.end();

                if (i == 0) {
                    isOnlyDot = checkLine(lines[i + 1], start, end) && checkLine(lines[i], start, end);
                } else if (i == lines.length - 1) {
                    isOnlyDot = checkLine(lines[i - 1], start, end) && checkLine(lines[i], start, end);
                } else {
                    isOnlyDot = checkLine(lines[i - 1], start, end) && checkLine(lines[i + 1], start, end) && checkLine(lines[i], start, end);
                }
                if (isOnlyDot) {
                    System.out.println("The number " + number + " is surrounded by dots");
                }
                if (!isOnlyDot) {
                    sum += Integer.parseInt(number);
                }
            }
        }
        System.out.println("The sum of all numbers is " + sum);
    }

    public boolean checkLine(String line, int start, int end) {
        boolean isOnlyDot = true;
        while (start <= end && isOnlyDot) {
            if (line.charAt(start) != '.' && !Character.isDigit(line.charAt(start))) {
                isOnlyDot = false;
            }
            start++;
        }
        return isOnlyDot;
    }
}
