package day19;

public class Condition {
    int value;
    String destination;
    String operator;
    String source;

    public Condition(int value, String destination, String operator, String source) {
        this.value = value;
        this.destination = destination;
        this.operator = operator;
        this.source = source;
    }

    public Condition(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        if (source == null)
            return "\t" + destination;
        return "\t" + source + " " + operator + " " + value + ": " + destination;
    }
}
