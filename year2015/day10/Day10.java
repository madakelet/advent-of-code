package year2015.day10;

public class Day10 {
    public static void main(String[] args) {
        String input = "3113322113";
        for(int i = 0; i < 40; i++) {
            input = lookAndSay(input);
        }
        System.out.println("Length: " + input.length());
        for(int i = 0; i < 10; i++) {
            input = lookAndSay(input);
        }
        System.out.println("Length: " + input.length());
    }

    public static String lookAndSay(String input) {
        StringBuilder builder = new StringBuilder();
        char[] chars = input.toCharArray();
        char current = chars[0];
        int counter = 1;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == current) {
                counter++;
            } else {
                builder.append(counter);
                builder.append(current);
                current = chars[i];
                counter = 1;
            }
        }
        builder.append(counter);
        builder.append(current);
        return builder.toString();
    }
}
