package year2017.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day1Test {
    @Test
    public void testCountNumbers() {
        String input = "1122";
        int expected = 3;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input));

        input = "1111";
        expected = 4;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input));

        input = "1234";
        expected = 0;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input));

        input = "91212129";
        expected = 9;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input));
    }
}
