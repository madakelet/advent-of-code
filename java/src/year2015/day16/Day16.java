package year2015.day16;

public class Day16 {
    static int sueNumber;

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day16/input.txt");
        for (String line : lines.split("\n")) {
            processLine(line);
        }
        System.out.println("Sue: " + sueNumber);
    }

    static void processLine(String line) {
        line = line.replace(":", "");
        line = line.replace(",", "");
        String[] parts = line.split(" ");
        int currentSueNumer = Integer.parseInt(parts[1]);
        Sue sue = initSue();
        Sue currentSue = new Sue();
        for (int i = 0; i < parts.length; i++) {
            if (i > 1) {
                if (i % 2 == 0) {
                    switch (parts[i]) {
                        case "children":
                            currentSue.children = parts[i + 1];
                            break;
                        case "cats":
                            currentSue.cats = parts[i + 1];
                            break;
                        case "samoyeds":
                            currentSue.samoyeds = parts[i + 1];
                            break;
                        case "pomeranians":
                            currentSue.pomeranians = parts[i + 1];
                            break;
                        case "akitas":
                            currentSue.akitas = parts[i + 1];
                            break;
                        case "vizslas":
                            currentSue.vizslas = parts[i + 1];
                            break;
                        case "goldfish":
                            currentSue.goldfish = parts[i + 1];
                            break;
                        case "trees":
                            currentSue.trees = parts[i + 1];
                            break;
                        case "cars":
                            currentSue.cars = parts[i + 1];
                            break;
                        case "perfumes":
                            currentSue.perfumes = parts[i + 1];
                            break;
                        default:
                            System.out.println("Wrong case for " + parts[i]);
                            break;
                    }
                }
            }
        }
        if (isSue(currentSue, sue))
            sueNumber = currentSueNumer;
    }

    static Sue initSue() {
        Sue sue = new Sue();

        sue.children = "3";
        sue.cats = "7";
        sue.samoyeds = "2";
        sue.pomeranians = "3";
        sue.akitas = "0";
        sue.vizslas = "0";
        sue.goldfish = "5";
        sue.trees = "3";
        sue.cars = "2";
        sue.perfumes = "1";

        return sue;
    }

    static boolean isSue(Sue currentSue, Sue sue) {
        return checkCompound(currentSue, sue, "children") 
                && checkCompound(currentSue, sue, "cats")
                && checkCompound(currentSue, sue, "samoyeds") 
                && checkCompound(currentSue, sue, "pomeranians")
                && checkCompound(currentSue, sue, "akitas") 
                && checkCompound(currentSue, sue, "vizslas")
                && checkCompound(currentSue, sue, "goldfish") 
                && checkCompound(currentSue, sue, "trees")
                && checkCompound(currentSue, sue, "cars") 
                && checkCompound(currentSue, sue, "perfumes");
    }

    static boolean checkCompound(Sue currentSue, Sue sue, String compound) {
        if (currentSue.getCompound(compound) == null)
            return true;
        return currentSue.getCompound(compound).equals(sue.getCompound(compound));
    }
}
