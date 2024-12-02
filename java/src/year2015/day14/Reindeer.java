package year2015.day14;

public class Reindeer {
    int speed;
    int flyTime;
    int restTime;
    int distance;
    String name;
    int points = 0;

    public Reindeer(int speed, int flyTime, int restTime, String name) {
        this.speed = speed;
        this.flyTime = flyTime;
        this.restTime = restTime;
        this.distance = 0;
        this.name = name;
    }
}
