package year2016.day21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day21Test {
    @Test
    public void testSwap() {
        String operation = "swap position 4 with position 0";
        String input = "abcde";
        String expected = "ebcda";
        assertEquals(expected, year2016.day21.Day21.swap(input, operation));
        // reverse
        assertEquals(input, year2016.day21.Day21.swap(expected, operation));

        operation = "swap letter d with letter b";
        expected = "adcbe";
        assertEquals(expected, year2016.day21.Day21.swap(input, operation));
        // reverse
        assertEquals(input, year2016.day21.Day21.swap(expected, operation));
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
        assertEquals(expected, year2016.day21.Day21.rotateBasedOnPosition(input, "b", false));
        input = "ecabd";
        expected = "decab";
        assertEquals(expected, year2016.day21.Day21.rotateBasedOnPosition(input, "d", false));
    }

    @Test
    public void testReverseSubstring() {
        String input = "edcba";
        String expected = "abcde";
        String operation = "reverse positions 0 through 4";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));
        // reverse
        assertEquals(input, year2016.day21.Day21.reverseSubString(expected, operation));

        operation = "reverse positions 1 through 4";
        expected = "eabcd";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));
        // reverse
        assertEquals(input, year2016.day21.Day21.reverseSubString(expected, operation));

        operation = "reverse positions 1 through 3";
        expected = "ebcda";
        assertEquals(expected, year2016.day21.Day21.reverseSubString(input, operation));
        // reverse
        assertEquals(input, year2016.day21.Day21.reverseSubString(expected, operation));
    }

    @Test
    public void testMoveToPosition() {
        String operation = "move position 1 to position 4";
        String input = "bcdea";
        String expected = "bdeac";
        assertEquals(expected, year2016.day21.Day21.move(input, operation, false));
        // reverse
        assertEquals(input, year2016.day21.Day21.move(expected, operation, true));

        input = "bdeac";
        expected = "abdec";
        operation = "move position 3 to position 0";
        assertEquals(expected, year2016.day21.Day21.move(input, operation, false));
        // reverse
        assertEquals(input, year2016.day21.Day21.move(expected, operation, true));
    }

    @Test
    public void testRotateGeneral() {
        // rotate right
        String operation = "rotate right 1 step";
        String input = "abc";
        String expected = "cab";
        assertEquals(expected, year2016.day21.Day21.rotate(input, operation, false));
        // reverse
        assertEquals(input, year2016.day21.Day21.rotate(expected, operation, true));

        // rotate left
        operation = "rotate left 1 steps";
        expected = "bca";
        assertEquals(expected, year2016.day21.Day21.rotate(input, operation, false));
        // reverse
        assertEquals(input, year2016.day21.Day21.rotate(expected, operation, true));

        input = "abcde";
        operation = "rotate based on position of letter e";
        expected = "eabcd";
        assertEquals(expected, year2016.day21.Day21.rotate(input, operation, false));
        assertEquals(input, year2016.day21.Day21.rotate(expected, operation, true));

        input = "abcdef";
        expected = "abcdef";
        assertEquals(expected, year2016.day21.Day21.rotate(input, operation, false));
        // reverse
        assertEquals(input, year2016.day21.Day21.rotate(expected, operation, true));

        input = "abcde";
        operation = "rotate based on position of letter c";
        expected = "cdeab";
        assertEquals(expected, year2016.day21.Day21.rotate(input, operation, false));
        assertEquals(input, year2016.day21.Day21.rotate(expected, operation, true));

    }
}
