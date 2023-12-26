package year2015.day6;

public class Day6 {
    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day6/input.txt");
        int[][] grid = new int[1000][1000];
        int[][] grid2 = new int[1000][1000];
        String[] instructions = lines.split("\n");
        for (String line : instructions) {
            String[] parts = line.split(" ");
            String[] start = parts[parts.length - 3].split(",");
            String[] end = parts[parts.length - 1].split(",");
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    if (parts[0].equals("toggle")) {
                        if (grid[i][j] == 0) {
                            grid[i][j] = 1;
                        } else {
                            grid[i][j] = 0;
                        }
                        grid2[i][j] += 2;
                    } else if (parts[1].equals("on")) {
                        grid[i][j] = 1;
                        grid2[i][j] += 1;
                    } else if (parts[1].equals("off")) {
                        grid[i][j] = 0;
                        if (grid2[i][j] > 0) {
                            grid2[i][j] -= 1;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
        count = 0;
        for (int[] row : grid2) {
            for (int cell : row) {
                count += cell;
            }
        }
        System.out.println(count);
    }
}
