package year2016.day7;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class Day7Test {
    @Test 
    @DisplayName("TestContainsPair")
    public void testcontainsDoublePairWithPair() {
        assertTrue("Expecting to be true for string abba", year2016.day7.Day7.containsDoublePair("abba"));
    }

    @Test 
    public void testcontainsDoublePairWithPairInsideString() {
        assertTrue("Expecting to be true for string sdabbaf", year2016.day7.Day7.containsDoublePair("sdabbaf"));
    }

    @Test 
    public void testcontainsDoublePairWithPairBeginningOfString() {
        assertTrue("Expecting to be true for string abbafssda", year2016.day7.Day7.containsDoublePair("abbafssda"));
    }

    @Test 
    public void testcontainsDoublePairWithPairEndOfString() {
        assertTrue("Expecting to be true for string aswermabba", year2016.day7.Day7.containsDoublePair("aswermabba"));
    }

    @Test
    public void testcontainsDoublePairWithNoPair() {
        assertFalse("Expecting to be false for xyza", year2016.day7.Day7.containsDoublePair("xyza"));
    }

    @Test
    public void ipSupportsTlsBeggining() {
        assertTrue("Expecting to be true for abba[mnop]qrst", year2016.day7.Day7.ipSupportsTls("abba[mnop]qrst"));
    }

    @Test
    public void ipSupportsTlsEnd() {
        assertTrue("Expecting to be true for asdasd[mnop]qrstabba", year2016.day7.Day7.ipSupportsTls("asdasd[mnop]qrstabba"));
    }

    @Test
    public void ipSupportsTlsMiddle() {
        assertTrue("Expecting to be true for asdasd[mnop]qrstabba[qwerr]asdasdw", year2016.day7.Day7.ipSupportsTls("asdasd[mnop]qrstabba[qwerr]asdasdw"));
    }

    @Test
    public void ipSupportsFalseWithOnlyInsideBrackets() {
        assertFalse("Expecting to be false for aqédlfor[abba]ameorvk", year2016.day7.Day7.ipSupportsTls("aqédlfor[abba]ameorvk"));
    }

    @Test
    public void ipSupportsFalseWithInsideAndOutside() {
        assertFalse("Expecting to be flase for abba[abba]ameorvk", year2016.day7.Day7.ipSupportsTls("abba[abba]ameorvk"));
    }

    @Test
    public void sandwichesListReturnsOneSandwich() {
        List<String> expected = new ArrayList<>();
        expected.add("bab");

        List<String> returned = new ArrayList<>();
        returned = year2016.day7.Day7.sandwichesList("aba");

        assertEquals(expected, returned);
    }
     
    @Test
    public void sandwichesListReturnsMultipleSandwiches() {
        List<String> expected = new ArrayList<>();
        expected.add("bab");
        expected.add("aba");

        List<String> returned = new ArrayList<>();
        returned = year2016.day7.Day7.sandwichesList("abab");

        assertEquals(expected, returned);
    }

    @Test
    public void sandwichesListReturnsEmpty() {
        List<String> expected = new ArrayList<>();

        List<String> returned = new ArrayList<>();
        returned = year2016.day7.Day7.sandwichesList("abewrl");

        assertEquals(expected, returned);
    }

    @Test
    public void sandwichesListReturnsEmptyForDash() {
        List<String> expected = new ArrayList<>();

        List<String> returned = new ArrayList<>();
        returned = year2016.day7.Day7.sandwichesList("a-awrll");

        assertEquals(expected, returned);
    }

    @Test 
    public void supportsSsl() {
        assertTrue(year2016.day7.Day7.ipSupportsSsl("aba[bab]xyz"));
    }
}

