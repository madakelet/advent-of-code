package year2017.day3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.Point;

public class Day3Test {
    @Test
    public void testfindRing() {
        int value = 1;
        int expected = 1;
        assertEquals(expected, year2017.day3.Day3.findRing(value));
        value = 2;
        expected = 2;
        assertEquals(expected, year2017.day3.Day3.findRing(value));
        value = 9;
        assertEquals(expected, year2017.day3.Day3.findRing(value));
        value = 10;
        expected = 3;
        assertEquals(expected, year2017.day3.Day3.findRing(value));
        value = 25;
        assertEquals(expected, year2017.day3.Day3.findRing(value));
    }

    @Test
    public void testHighestValue() {
        int ring = 1;
        int expected = 1;
        assertEquals(expected, year2017.day3.Day3.highestValueInRing(ring));
        ring = 2;
        expected = 9;
        assertEquals(expected, year2017.day3.Day3.highestValueInRing(ring));
        ring = 3;
        expected = 25;
        assertEquals(expected, year2017.day3.Day3.highestValueInRing(ring));
    }

    @Test
    public void testFindPoint() {
        int value = 25;
        Point expected = new Point(2, -2);
        // right bottom corner
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);

        // right side
        value = 13;
        expected.y = 2;
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);

        value = 11;
        expected.y = 0;
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);

        // top
        value = 14;
        expected.x = 1;
        expected.y = 2;
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);

        value = 15;
        expected.x = 0;
        expected.y = 2;
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);

        value = 16;
        expected.x = -1;
        expected.y = 2;
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);

        value = 32;
        expected.x = 2;
        expected.y = 3;
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);

        // left side
        value = 17;
        expected.x = -2;
        expected.y = 2;
        assertEquals(expected.y, year2017.day3.Day3.findPoint(value).y);
        assertEquals(expected.x, year2017.day3.Day3.findPoint(value).x);

    }

    @Test
    public void testNumberOfValuesOnRing() {
        int ring = 1;
        int expected = 1;
        assertEquals(expected, year2017.day3.Day3.numberOfValuesOnRing(ring));

        ring = 2;
        expected = 8;
        assertEquals(expected, year2017.day3.Day3.numberOfValuesOnRing(ring));

        ring = 3;
        expected = 16;
        assertEquals(expected, year2017.day3.Day3.numberOfValuesOnRing(ring));

        ring = 4;
        expected = 24;
        assertEquals(expected, year2017.day3.Day3.numberOfValuesOnRing(ring));

        ring = 5;
        expected = 32;
        assertEquals(expected, year2017.day3.Day3.numberOfValuesOnRing(ring));

    }
}
