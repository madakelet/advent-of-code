package year2016.day1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Day1Test {
    @Test
    public void testGetFacingNTurnR() {
        assertEquals("Expected facing to be 'E' after turning right from 'N'", 'E', year2016.day1.Day1.getFacing('N', 'R'));
    }

    @Test
    public void testGetFacingNTurnL() {
        assertEquals('W', year2016.day1.Day1.getFacing('N', 'L'));
    }

    @Test
    public void testGetFacingWTurnR() {
        assertEquals('N', year2016.day1.Day1.getFacing('W', 'R'));
    }

    @Test
    public void testGetFacingWTurnL() {
        assertEquals('S', year2016.day1.Day1.getFacing('W', 'L'));
    }

    @Test
    public void testGetFacingSTurnR() {
        assertEquals('W', year2016.day1.Day1.getFacing('S', 'R'));
    }

    @Test
    public void testGetFacingSTurnL() {
        assertEquals('E', year2016.day1.Day1.getFacing('S', 'L'));
    }

    @Test
    public void testGetFacingETurnR() {
        assertEquals('S', year2016.day1.Day1.getFacing('E', 'R'));
    }

    @Test
    public void testGetFacingETurnL() {
        assertEquals('N', year2016.day1.Day1.getFacing('E', 'L'));
    }
}
