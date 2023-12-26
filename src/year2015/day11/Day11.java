package year2015.day11;

public class Day11 {
    public static void main(String[] args) {
        String input = "hepxcrrq";
        input = updatePassword(input);
        System.out.println(input);  
        input = updatePassword(input);
        System.out.println(input);
    }

    static String updatePassword(String input) {
        do {
            input = incrementPassword(input);
        } while (!isValidPassword(input));
        return input;
    }

    static String incrementPassword(String input) {
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 'z') {
                chars[i] = 'a';
            } else {
                chars[i]++;
                break;
            }
        }
        return new String(chars);
    }

    static boolean isValidPassword(String input) {
        return hasIncreasingStraight(input) && !hasForbiddenLetters(input) && hasTwoPairs(input);
    }

    static boolean hasIncreasingStraight(String input) {
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) + 1 == input.charAt(i + 1) && input.charAt(i) + 2 == input.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasForbiddenLetters(String input) {
        return input.contains("i") || input.contains("o") || input.contains("l");
    }

    static boolean hasTwoPairs(String input) {
        int pairs = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                pairs++;
                i++;
            }
        }
        return pairs >= 2;
    }
}
