package year2015.day23;

public class Day23 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day23/input.txt");
        processLine(lines, 0, 0);
        processLine(lines, 1, 0);
    }

    static void processLine(String lines, int registerA, int registerB) {
        lines = lines.replace(",", "");
        String parts[] = lines.split("\n");
        for (int i = 0; i < parts.length; i++) {
            String[] lineSplit = parts[i].split(" ");
            switch (lineSplit[0]) {
                case "hlf":
                    if (lineSplit[1].equals("a")) {
                        registerA = registerA / 2;
                    } else {
                        registerB = registerB / 2;
                    }
                    break;
                case "tpl":
                    if (lineSplit[1].equals("a")) {
                        registerA = registerA * 3;
                    } else {
                        registerB = registerB * 3;
                    }
                    break;
                case "inc":
                    if (lineSplit[1].equals("a")) {
                        registerA++;
                    } else {
                        registerB++;
                    }
                    break;
                case "jmp":
                    i += Integer.parseInt(lineSplit[1]) - 1;
                    break;
                case "jie":
                    if (lineSplit[1].equals("a")) {
                        if (registerA % 2 == 0) {
                            i += Integer.parseInt(lineSplit[2]) - 1;
                        }
                    } else {
                        if (registerB % 2 == 0) {
                            i += Integer.parseInt(lineSplit[2]) - 1;
                        }
                    }
                    break;
                case "jio":
                    if (lineSplit[1].equals("a")) {
                        if (registerA == 1) {
                            i += Integer.parseInt(lineSplit[2]) - 1;
                        }
                    } else {
                        if (registerB == 1) {
                            i += Integer.parseInt(lineSplit[2]) - 1;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid instruction");
                    break;
            }
        }
        System.out.println("Register A: " + registerA);
        System.out.println("Register B: " + registerB);
    }
}
