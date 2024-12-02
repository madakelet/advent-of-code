package year2016.day18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day18Test {
    @Test
    public void testGenerateRow() {
        String row1 = "..^^.";
        String nextRow = year2016.day18.Day18.generateNextRow(row1);
        assertEquals(".^^^^", nextRow);   
        assertEquals("^^..^", year2016.day18.Day18.generateNextRow(nextRow));

        row1 = ".^^.^.^^^^";
        nextRow = year2016.day18.Day18.generateNextRow(row1);
        assertEquals("^^^...^..^", nextRow);   
        assertEquals("^.^^.^.^^.", year2016.day18.Day18.generateNextRow(nextRow));
    }
}
