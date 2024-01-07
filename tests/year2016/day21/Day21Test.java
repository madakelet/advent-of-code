package year2016.day21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day21Test {
    @Test
    public void testSwap() {
        String operation = "swap position 4 with position 0";
        String input = "abcde";
        String expected = "ebcda";
        input = year2016.day21.Day21.swap(input, operation);
        assertEquals(expected, input);

        operation = "swap letter d with letter b";
        input = year2016.day21.Day21.swap(input, operation);
        expected = "edcba";
        assertEquals(expected, input);
    }

    @Test
    public void testRotateRight() {
        String input = "abcde";
        String expected = "eabcd";
        assertEquals(expected, year2016.day21.Day21.rotateRight(input, "1"));
        assertEquals(expected, year2016.day21.Day21.rotateRight(input, "6"));
        expected = "deabc";
        assertEquals(expected, year2016.day21.Day21.rotateRight(input, "2"));
        expected = "abcde";
        assertEquals(expected, year2016.day21.Day21.rotateRight(input, "5"));
    }

    @Test
    public void testRotateLeft() {
        String input = "abcde";
        String expected = "bcdea";
        assertEquals(expected, year2016.day21.Day21.rotateLeft(input, "1"));
        assertEquals(expected, year2016.day21.Day21.rotateLeft(input, "6"));
        expected = "cdeab";
        assertEquals(expected, year2016.day21.Day21.rotateLeft(input, "2"));
        expected = "abcde";
        assertEquals(expected, year2016.day21.Day21.rotateLeft(input, "5"));
    }

    @Test

    public void testRotateBasedOnPosition() {
        String input = "abdec";
        String expected = "ecabd";
        assertEquals(expected, year2016.day21.Day21.rotateBasedOnPosition(input, "b"));
        input = "ecabd";
        expected = "decab";
        assertEquals(expected, year2016.day21.Day21.rotateBasedOnPosition(input, "d"));
    }

    @Test

    public void testReverseSubstring() {
        String input = "edcba";
        String expected = "abcde";
        String operation = "reverse positions 0 through 4";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));

        operation = "reverse positions 1 through 4";
        expected = "eabcd";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));

        operation = "reverse positions 1 through 3";
        expected = "ebcda";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));
    }

    @Test

    public void testMoveToPosition() {
        String operation = "move position 1 to position 4";
        String input = "bcdea";
        String expected = "bdeac";
        assertEquals(expected, year2016.day21.Day21.movePosition(input, operation));

        input = "bdeac";
        expected = "abdec";
        operation = "move position 3 to position 0";
        assertEquals(expected, year2016.day21.Day21.movePosition(input, operation));

    }
}
