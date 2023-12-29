package year2016.day9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day9Test {
    @Test
    public void findNumbers() {
        String expected = "2x4";
        assertEquals(expected, year2016.day9.Day9.findNumbers(0, "2x4)"));
    }

    @Test
    public void findLongerNumbers() {
        String expected = "2222x44";
        assertEquals(expected, year2016.day9.Day9.findNumbers(0, "2222x44)"));
    }

    @Test
    public void closingParenthesis() {
        int expected = 4;
        assertEquals(expected, year2016.day9.Day9.closingParenthesis(0, "12x2)a"));
    }

    @Test
    public void closingParenthesisNotThereReturnsLength() {
        String line = "123x2344";
        int expected = line.length();
        assertEquals(expected, year2016.day9.Day9.closingParenthesis(0, line));
    }

    @Test
    public void closingParenthesisMiddle() {
        String line = "123x23)asd";
        int expected = 6;
        assertEquals(expected, year2016.day9.Day9.closingParenthesis(0, line));
    }

    @Test
    public void decompressWithoutParenthesis() {
        String expecteString = "ADVENT";
        String input = "ADVENT";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }

    @Test
    public void decompressWithOneRepeat() {
        String expecteString = "ABBBBBC";
        String input = "A(1x5)BC";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }

    @Test
    public void decompressParenthesisAtBegining() {
        String expecteString = "XYZXYZXYZ";
        String input = "(3x3)XYZ";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }

    @Test
    public void decompressMultipleParthesis() {
        String expecteString = "ABCBCDEFEFG";
        String input = "A(2x2)BCD(2x2)EFG";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }

    @Test
    public void decompressMultipleParthesisNextToEachOther() {
        String expecteString = "(1x3)A";
        String input = "(6x1)(1x3)A";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }

    @Test
    public void decompressMultipleParthesisRepeatMultiple() {
        String expecteString = "X(3x3)ABC(3x3)ABCY";
        String input = "X(8x2)(3x3)ABCY";
        assertEquals(expecteString, year2016.day9.Day9.decompressLine(input));
    }
}
