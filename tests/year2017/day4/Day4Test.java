package year2017.day4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Day4Test {
    @Test
    public void testIsValidPassPhrase() {
        String phrase = "aa bb cc dd ee";
        assertTrue(year2017.day4.Day4.isValidPassphrase(phrase, true));
        phrase = "aa bb cc dd aa";
        assertFalse(year2017.day4.Day4.isValidPassphrase(phrase, true));
        phrase = "aa bb cc dd aaa";
        assertTrue(year2017.day4.Day4.isValidPassphrase(phrase, true));

        // part 2

        phrase = "abcde fghij";
        assertTrue(year2017.day4.Day4.isValidPassphrase(phrase, false));

        phrase = "iiii oiii ooii oooi oooo";
        assertTrue(year2017.day4.Day4.isValidPassphrase(phrase, false));

        phrase = "oiii ioii iioi iiio";
        assertFalse(year2017.day4.Day4.isValidPassphrase(phrase, false));

        phrase = "abcde xyz ecdab";
        assertFalse(year2017.day4.Day4.isValidPassphrase(phrase, false));

        phrase = "ufzn mrhiapi qrme kjlf qrme xpp qrme loyzizz xqm coli";
        assertFalse(year2017.day4.Day4.isValidPassphrase(phrase, false));

    }
}
