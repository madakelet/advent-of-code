package year2016.day16;

public class Day16 {
    static String dragonCurve(String input) {
        StringBuilder builder = new StringBuilder();
        builder.append(input).append("0");
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            char toAppend = c == '0' ? '1' : '0';
            builder.append(toAppend);
        }
        return builder.toString();
    }

    static String checkSum(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i += 2) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            char toAppend = currentChar == nextChar ? '1' : '0';
            builder.append(toAppend);
        }
        return builder.toString();
    }

    static void solve(int discSize, String input) {
        while (input.length() < discSize) {
            input = dragonCurve(input);
        }
        input = input.substring(0, discSize);
        while (input.length() % 2 == 0) {
            input = checkSum(input);
        }
        System.out.println("With  " + discSize + ": " + input);
    }

    public static void main(String[] args) {
        String input = "01000100010010111";
        solve(272, input);
        solve(35651584, input);
    }
}
