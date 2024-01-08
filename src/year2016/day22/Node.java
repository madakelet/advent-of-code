package year2016.day22;

public class Node {
    int x;
    int y;
    int size;
    int used;
    int avail;
    int percent;

    public Node(int x, int y, int size, int used, int avail, int percent) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.used = used;
        this.avail = avail;
        this.percent = percent;
    }

    public boolean isVailablePair(Node otherNode) {
        if (this.used == 0) {
            return false;
        }
        if (this.used > otherNode.avail) {
            return false;
        }
        if (this.x == otherNode.x && this.y == otherNode.y) {
            return false;
        }
        return true;
    }

    @Override

    public String toString() {
        return "(" + x + ", " + y + ") with size: " + size + " used: " + used + " available: " + avail;
    }
}
