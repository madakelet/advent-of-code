package year2016.day15;

public class Disc {
    int positions;
    int startPosition;
    int discNr;

    public Disc(int positions, int startPosition, int discNr) {
        this.positions = positions;
        this.startPosition = startPosition;
        this.discNr = discNr;
    }

    @Override

    public String toString() {
        return "Disc #" + discNr + " starting position at " + startPosition + " with total positions of " + positions;
    }
}
