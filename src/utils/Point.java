package utils;

import java.util.Objects;

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
