package year2016.day23;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day23Test {
    @Test
    public void testNegativeParsing() {
        String numberString = "-12";
        int value = Integer.parseInt(numberString);
        assertEquals(-12, value);
    }
}
