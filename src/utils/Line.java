package utils;

public class Line {
    public Point start, end;

    public Line() {
        this(new Point(0, 0), new Point(0, 0));
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public boolean doesIntersect(Line other) {
        return doesIntersect(this.start.x, this.start.y, this.end.x, this.end.y, other.start.x, other.start.y, other.end.x, other.end.y);
    }

    public static boolean doesIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4 ) {
        int a1 = y2 - y1;
        int b1 = x1 - x2;
        int c1 = a1 * x1 + b1 * y1;
        int a2 = y4 - y3;
        int b2 = x3 - x4;
        int c2 = a2 * x3 + b2 * y3;
        int determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return false;
        } else {
            int x = (b2 * c1 - b1 * c2) / determinant;
            int y = (a1 * c2 - a2 * c1) / determinant;
            return isBetween(x1, y1, x2, y2, x, y) && isBetween(x3, y3, x4, y4, x, y);
        }
    }

    public static boolean isBetween(int x1, int y1, int x2, int y2, int x, int y) {
        return (x >= x1 && x <= x2 || x >= x2 && x <= x1) && (y >= y1 && y <= y2 || y >= y2 && y <= y1);
    }

    public Point intersectionPoint(Line other) {
        return intersectionPoint(this.start.x, this.start.y, this.end.x, this.end.y, other.start.x, other.start.y, other.end.x, other.end.y);
    }

    public static Point intersectionPoint(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4 ) {
        int a1 = y2 - y1;
        int b1 = x1 - x2;
        int c1 = a1 * x1 + b1 * y1;
        int a2 = y4 - y3;
        int b2 = x3 - x4;
        int c2 = a2 * x3 + b2 * y3;
        int determinant = a1 * b2 - a2 * b1;
        if (determinant == 0) {
            return null;
        } else {
            int x = (b2 * c1 - b1 * c2) / determinant;
            int y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
    }

    @Override 

    public String toString() {
        return String.format("Line(%s, %s)", this.start, this.end);
    }
}
