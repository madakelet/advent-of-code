package year2015.day21;

import java.util.ArrayList;
import java.util.List;

public class Day21 {
    static List<Item> weapons = new ArrayList<>();
    static List<Item> armors = new ArrayList<>();
    static List<Item> rings = new ArrayList<>();
    static int bossHP, bossDamage, bossArmor, playerHP;

    public static void main(String[] args) {
        String weaponsLines = utils.ReadFile.readFromFile("year2015/day21/weapons.txt");
        String armorsLines = utils.ReadFile.readFromFile("year2015/day21/armors.txt");
        String ringsLines = utils.ReadFile.readFromFile("year2015/day21/rings.txt");
        parseItems(weaponsLines, weapons);
        parseItems(armorsLines, armors);
        parseItems(ringsLines, rings);
        System.out.println("weapons cost: " + fightOnlySword());
        System.out.println("weapons and armor cost: " + fightWithArmor());
        System.out.println("weapons, armor and one ring cost: " + fightWithOneRing());
        System.out.println("weapons, armor and two rings cost: " + fightWithTwoRings());
        System.out.println("weapons and one ring cost: " + fightWithoutArmorOneRing());
        System.out.println("weapons and two rings cost: " + fightWithourArmorTwoRings());
    }

    public static void parseItems(String items, List<Item> list) {
        String[] lines = items.split("\n");
        for (String line : lines) {
            line = line.replaceAll("\\s+", " ");
            String[] parts = line.split(" ");
            int cost, damage, armor;
            String name = parts[0];
            if (parts[1].contains("+")) {
                name += " " + parts[1];
                cost = Integer.parseInt(parts[2]);
                damage = Integer.parseInt(parts[3]);
                armor = Integer.parseInt(parts[4]);
            } else {
                cost = Integer.parseInt(parts[1]);
                damage = Integer.parseInt(parts[2]);
                armor = Integer.parseInt(parts[3]);
            }
            list.add(new Item(name, cost, damage, armor));
        }
    }

    static int fightOnlySword() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            //System.out.println("currently checking: " + weapon.toString());
            int cost = weapon.cost;
            int damage = weapon.damage;
            int armor = weapon.armor;
            if (canWinFight(damage, armor)) {
                minCost = Math.min(minCost, cost);
            }
            if(!canWinFight(damage, armor)) {
                maxCost = Math.max(maxCost, cost);
            }
        }
        //return minCost == Integer.MAX_VALUE ? 0 : minCost;
        return maxCost;
    }

    static int fightWithArmor() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            for (Item armor : armors) {
                //System.out.println("currently checking:   " + weapon.toString() + " " + armor.toString());
                int cost = weapon.cost + armor.cost;
                int damage = weapon.damage;
                int armorValue = armor.armor;
                if (canWinFight(damage, armorValue)) {
                    minCost = Math.min(minCost, cost);
                }
                if(!canWinFight(damage, armorValue)) {
                    maxCost = Math.max(maxCost, cost);
                }
            }
        }
        //return minCost;
        return maxCost;
    }

    static int fightWithOneRing() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            for (Item armor : armors) {
                for (Item ring : rings) {
                    //System.out.println("currently checking:   " + weapon.toString() + " " + armor.toString() + " " + ring.toString());
                    int cost = weapon.cost + armor.cost + ring.cost;
                    int damage = weapon.damage + ring.damage;
                    int armorValue = armor.armor + ring.armor;
                    if (canWinFight(damage, armorValue)) {
                        minCost = Math.min(minCost, cost);
                    }
                    if(!canWinFight(damage, armorValue)) {
                        maxCost = Math.max(maxCost, cost);
                    }
                }
            }
        }
        //return minCost;
        return maxCost;
    }

    static int fightWithTwoRings() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            for (Item armor : armors) {
                for (Item ring1 : rings) {
                    for (Item ring2 : rings) {
                        if (ring1.name.equals(ring2.name)) {
                            continue;
                        }
                        //System.out.println("currently checking:   " + weapon.toString() + " " + armor.toString() + " " + ring1.toString() + " " + ring2.toString());
                        int cost = weapon.cost + armor.cost + ring1.cost + ring2.cost;
                        int damage = weapon.damage + ring1.damage + ring2.damage;
                        int armorValue = armor.armor + ring1.armor + ring2.armor;
                        if (canWinFight(damage, armorValue)) {
                            minCost = Math.min(minCost, cost);
                        }
                        if(!canWinFight(damage, armorValue)) {
                            maxCost = Math.max(maxCost, cost);
                        }
                    }
                }
            }
        }
        //return minCost;
        return maxCost;
    }

    static int fightWithoutArmorOneRing() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            for (Item ring : rings) {
                //System.out.println("currently checking:   " + weapon.toString() + " " + ring.toString());
                int cost = weapon.cost + ring.cost;
                int damage = weapon.damage + ring.damage;
                int armorValue = ring.armor;
                if (canWinFight(damage, armorValue)) {
                    minCost = Math.min(minCost, cost);
                }
                if(!canWinFight(damage, armorValue)) {
                    maxCost = Math.max(maxCost, cost);
                }
            }
        }
        //return minCost;
        return maxCost;
    }

    static int fightWithourArmorTwoRings() {
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (Item weapon : weapons) {
            for (Item ring1 : rings) {
                for (Item ring2 : rings) {
                    if (ring1.name.equals(ring2.name)) {
                        continue;
                    }
                    //System.out.println("currently checking:   " + weapon.toString() + " " + ring1.toString() + " " + ring2.toString());
                    int cost = weapon.cost + ring1.cost + ring2.cost;
                    int damage = weapon.damage + ring1.damage + ring2.damage;
                    int armorValue = ring1.armor + ring2.armor;
                    if (canWinFight(damage, armorValue)) {
                        minCost = Math.min(minCost, cost);
                    }
                    if(!canWinFight(damage, armorValue)) {
                        maxCost = Math.max(maxCost, cost);
                    }
                }
            }
        }
        //return minCost;
        return maxCost;
    }
    static boolean canWinFight(int playerDamage, int playerArmor) {
        initDefaultStats();
        while (true) {
            //System.out.println("Boss HP: " + bossHP + " Player HP: " + playerHP);
            bossHP -= Math.max(1, playerDamage - bossArmor);
            if (bossHP <= 0) {
                //System.out.println("Player wins");
                return true;
            }
            playerHP -= Math.max(1, bossDamage - playerArmor);
            if (playerHP <= 0) {
                //System.out.println("Boss wins");
                return false;
            }
        }
    }

    static private void initDefaultStats() {
        bossHP = 104;
        bossDamage = 8;
        bossArmor = 1;
        playerHP = 100;
    }
}
