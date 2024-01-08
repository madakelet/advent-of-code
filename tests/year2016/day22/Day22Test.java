package year2016.day22;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day22Test {
    @Test
    public void testGetPoint(){
        String input = "/dev/grid/node-x0-y5";
        int expectedX = 0;
        int expectedY = 5;

        assertEquals(expectedX, year2016.day22.Day22.getPoint(input, "x"));
        assertEquals(expectedY, year2016.day22.Day22.getPoint(input, "y"));
    }
}
