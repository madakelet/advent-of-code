package utils;

public class Point {
    public int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override

    public String toString() {
        if(this.x == 0 && this.y == 0)
            return "Origin";
        return "(" + this.x + ", " + this.y + ")";
    }
}
