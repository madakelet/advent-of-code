package year2023.day5;

public class Range {
    long start;
    long end;
    long length;
    long distance;

    public Range(long destination, long start, long length) {
        this.start = start;
        this.length = length;
        this.end = start + length - 1;
        this.distance = destination - start;
    }
}