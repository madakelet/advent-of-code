package year2015.day20;

public class Day20 {
    public static void main(String[] args) {
        int input = 36000000;
        int house = findHouseWithPresents(input);
        System.out.println("House number: " + house);

    }

    private static int findHouseWithPresents(int targetPresents) {
        int[] presents = new int[targetPresents / 10];

        for (int elfNumber = 1; elfNumber < presents.length; elfNumber++) {
            for (int houseNumber = elfNumber; houseNumber < presents.length; houseNumber += elfNumber) {
                presents[houseNumber] += elfNumber * 10;
            }
        }

        for (int houseNumber = 1; houseNumber < presents.length; houseNumber++) {
            if (presents[houseNumber] >= targetPresents) {
                return houseNumber;
            }
        }
        return -1;
    }

}
