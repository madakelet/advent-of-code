package year2017.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day1Test {
    @Test
    public void testCountNumbersPartOne() {
        String input = "1122";
        int expected = 3;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, true));

        input = "1111";
        expected = 4;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, true));

        input = "1234";
        expected = 0;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, true));

        input = "91212129";
        expected = 9;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, true));
    }
    @Test
    public void testCountNumbersPartTwo() {
        String input = "1212";
        int expected = 6;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, false));

        input = "1221";
        expected = 0;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, false));

        input = "123425";
        expected = 4;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, false));

        input = "123123";
        expected = 12;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, false));

        input = "12131415";
        expected = 4;
        assertEquals(expected, year2017.day1.Day1.countNumbers(input, false));
    }
}
