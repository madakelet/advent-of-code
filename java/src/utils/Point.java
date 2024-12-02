package utils;

import java.util.Objects;

public class Point {
    public int x, y;
    public char value;
    public boolean visited;

    public Point() {
        this.x = 0;
        this.y = 0;
        visited = false;
    }

    public Point(int x, int y) {
        this();
        this.x = x;
        this.y = y;
        visited = false;
    }

    /**
     * Constructs a new Point object with the specified coordinates and value.
     *
     * @param x     the x-coordinate of the point
     * @param y     the y-coordinate of the point
     * @param value the value associated with the point
     */

    public Point(int x, int y, char value) {
        this();
        this.x = x;
        this.y = y;
        this.value = value;
        visited = false;
    }

    @Override

    public String toString() {
        if (this.x == 0 && this.y == 0)
            return "Origin";
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
