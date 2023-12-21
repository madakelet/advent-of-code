package year2015.day16;

public class Sue {
    String children = null;
    String cats = null;
    String samoyeds = null;
    String pomeranians = null;
    String akitas = null;
    String vizslas = null;
    String goldfish = null;
    String trees = null;
    String cars = null;
    String perfumes = null;

    public String getCompound(String compound) {
        switch (compound) {
            case "children":
                return this.children;
            case "cats":
                return this.cats;
            case "samoyeds":
                return this.samoyeds;
            case "pomeranians":
                return this.pomeranians;
            case "akitas":
                return this.akitas;
            case "vizslas":
                return this.vizslas;
            case "goldfish":
                return this.goldfish;
            case "trees":
                return this.trees;
            case "cars":
                return this.cars;
            case "perfumes":
                return this.perfumes;
            default:
                return "Not found";
        }
    }

    @Override
    public String toString() {
        return "children: " + this.children +
                "cats: " + this.cats +
                "samoyeds: " + this.samoyeds +
                "pomeranians: " + this.pomeranians +
                "akitas: " + this.akitas +
                "vizslas: " + this.vizslas +
                "goldfish: " + this.goldfish +
                "trees: " + this.trees +
                "cars: " + this.cars +
                "perfumes: " + this.perfumes;
    }
}
