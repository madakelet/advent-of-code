package day13;

public class Pattern {
    public String lines;
    public String rotatedLines;
    public int mirrorIndex = 0;
    public int sumPoints;
    public Pattern(String lines) {
        this.lines = lines;
        this.rotatedLines = rotate(lines);
        findMirrorInLines(this.lines);
        if(isMirror(this.lines, mirrorIndex)) {
            System.out.println("Horizontally mirrored: " + this.mirrorIndex);
            sumPoints += mirrorIndex * 100;
        }
        mirrorIndex = 0;
        findMirrorInLines(this.rotatedLines);
        if(isMirror(this.rotatedLines, mirrorIndex)) {
            //System.out.println("Vertically mirrored, sum: " + mirrorIndex);
            sumPoints += mirrorIndex;
        }
        System.out.println();
    }

    public String rotate(String lines) {
        String[] rows = lines.split("\n");
        int rowsCount = rows.length;
        int colsCount = rows[0].length();

        char[][] rotatedGrid = new char[colsCount][rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                rotatedGrid[j][rowsCount - 1 - i] = rows[i].charAt(j);
            }
        }

        StringBuilder rotatedLinesString = new StringBuilder();
        for (int i = 0; i < colsCount; i++) {
            rotatedLinesString.append(rotatedGrid[i]).append('\n');
        }

        return rotatedLinesString.toString();
    }

    public void findMirrorInLines(String input) {
        String[] rows = input.split("\n");
        int i = 1;
        boolean found = false;
        while (i < rows.length && !found) {
            if (rows[i].equals(rows[i - 1])) {
                System.out.println(rows[i]);
                System.out.println(rows[i - 1]);
                if(isMirror(input, i)) {
                    mirrorIndex = i;
                }
            }
            i++;
        }
        //System.out.println("Mirrorindex: " + mirrorIndex);
    }

    public boolean isMirror(String input, int index) {
        String[] rows = input.split("\n");
        if (index == 1) {
            return true;
        } else if (index == (rows.length - 1)) {
            return true;
        } else {
            int distance = 1;
            boolean isMirror = true;
            while ((index + distance) < rows.length && (index - (distance + 1)) >= 0 && isMirror) {
                if (!(rows[index + distance].equals(rows[index - (distance + 1)]))) {
                    isMirror = false;
                }
                distance++;
            }
            return isMirror;
        }
    }
}
