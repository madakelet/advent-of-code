package year2016.day16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Day16Test {
    @Test
    public void dragonCurve() {
        String test1 = "1";
        String test2 = "0";
        String test3 = "11111";
        String test4 = "111100001010";

        assertEquals("100", year2016.day16.Day16.dragonCurve(test1));
        assertEquals("001", year2016.day16.Day16.dragonCurve(test2));
        assertEquals("11111000000", year2016.day16.Day16.dragonCurve(test3));
        assertEquals("1111000010100101011110000", year2016.day16.Day16.dragonCurve(test4));

    }

    @Test
    public void checkSum() {
        String test1 = "110010110100";

        assertEquals("110101", year2016.day16.Day16.checkSum(test1));
    }
}
