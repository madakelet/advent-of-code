package day11;

public class Galaxy {
    public int x;
    public int y;

    public Galaxy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Galaxy other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }   
}
