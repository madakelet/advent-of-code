package year2016.day19;

import java.util.ArrayList;
import java.util.List;

public class Day19 {

    static int getLastStanding(int elvesNr) {
        return 2 * (elvesNr - Integer.highestOneBit(elvesNr)) + 1;
    }

    public static void main(String[] args) {
        int elvesNr = 3001330;
        System.out.println("Part 1 : " + getLastStanding(elvesNr));
    }
}
