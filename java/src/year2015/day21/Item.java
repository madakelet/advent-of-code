package year2015.day21;

public class Item {
    String name;
    int cost;
    int damage;
    int armor;

    public Item(String name, int cost, int damage, int armor) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
    }

    public String toString() {
        return String.format("%s: cost %d, damage %d, armor %d", name, cost, damage, armor);
    }
}
