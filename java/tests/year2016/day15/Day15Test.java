package year2016.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Day15Test {
    @Test
    public void testPositions() {
        Disc disc1 = new Disc(2, 1, 2);
        Disc disc2 = new Disc(5, 4, 1);
        assertEquals(1, year2016.day15.Day15.positionAtTime(disc1, 2));
        assertEquals(0, year2016.day15.Day15.positionAtTime(disc2, 6));
    } 
}
