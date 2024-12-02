package year2016.day18;

import java.util.ArrayList;
import java.util.List;

public class Day18 {
    static List<String> rows = new ArrayList<>();

    static String generateNextRow(String row) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < row.length(); i++) {
            char center = row.charAt(i);
            char left = (i == 0) ? '.' : row.charAt(i - 1);
            char right = (i == row.length() - 1) ? '.' : row.charAt(i + 1);
            if (left == '^' && center == '^' && right != '^') {
                builder.append('^');
            } else if (center == '^' && right == '^' && left != '^') {
                builder.append('^');
            } else if (left == '^' && right != '^' && center != '^') {
                builder.append('^');
            } else if (right == '^' && left != '^' && center != '^') {
                builder.append('^');
            } else {
                builder.append('.');
            }
        }
        return builder.toString();
    }

    static void printRows() {
        for (String row : rows) {
            System.out.println(row);
        }
    }

    static int countSafeTiles() {
        int sum = 0;
        for (String row : rows) {
            for (char c : row.toCharArray()) {
                if (c == '.') {
                    sum++;
                }
            }
        }

        return sum;
    }

    static void addRows(int nrOfRows) {
        for (int i = 0; i < nrOfRows - 1; i++) {
            rows.add(generateNextRow(rows.get(i)));
        }
    }

    public static void main(String[] args) {
        String input = ".^^^^^.^^^..^^^^^...^.^..^^^.^^....^.^...^^^...^^^^..^...^...^^.^.^.......^..^^...^.^.^^..^^^^^...^.";
        rows.add(input);
        addRows(40);
        System.out.println("Part 1 : " + countSafeTiles());
        rows.clear();
        rows.add(input);
        addRows(400000);
        System.out.println("Part 2 : " + countSafeTiles());
    }
}
