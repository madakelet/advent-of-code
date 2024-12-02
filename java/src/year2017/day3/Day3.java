package year2017.day3;

import utils.Point;

public class Day3 {

    static int findRing(int value) {
        int ring = 1;
        while (true) {
            if (Math.pow((ring * 2) - 1, 2) >= value)
                break;
            ring++;
        }

        return ring;
    }

    static int highestValueInRing(int ring) {
        return ((ring * 2) - 1) * ((ring * 2) - 1);
    }

    static int numberOfValuesOnRing(int ring) {
        return ring > 1 ? (ring - 1) * 8 : 1;
    }

    static Point findPoint(int value) {
        int ring = findRing(value);
        int startingX = ring - 1;
        int startingY = -1 * startingX;

        Point p = new Point(startingX, startingY);

        int valuesOnRing = numberOfValuesOnRing(ring);
        int highestValue = highestValueInRing(ring);

        return p;
    }

    public static void main(String[] args) {
        int value = 368078;
        findPoint(value);
    }
}
