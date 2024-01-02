package year2023.day10;

import utils.ReadFile;

public class Day10 {
    static Character[][] pipes;
    static int startRow;
    static int startCol;

    static void processLines(String lines) {
        String[] linesSplit = lines.split("\n");
        pipes = new Character[linesSplit.length][linesSplit[0].length()];
        for (int row = 0; row < linesSplit.length; row++) {
            int col = 0;
            for (char c : linesSplit[row].toCharArray()) {
                if (c == 'S') {
                    startRow = row;
                    startCol = col;
                }
                pipes[row][col] = c;
                col++;
            }
        }
    }

    static char setFacing(char facing, char pipe) {
        switch (facing) {
            case 'N':
                if (pipe == '7') {
                    facing = 'W';
                } else if (pipe == 'F') {
                    facing = 'E';
                } else if (pipe == '-') {
                    facing = 'E';
                }
                break;
            case 'S':
                if (pipe == 'J') {
                    facing = 'W';
                } else if (pipe == 'L') {
                    facing = 'E';
                } else if (pipe == '-') {
                    facing = 'E';
                }
                break;
            case 'W':
                if (pipe == 'L') {
                    facing = 'N';
                } else if (pipe == 'F') {
                    facing = 'S';
                } else if (pipe == '|') {
                    facing = 'S';
                }
                break;
            case 'E':
                if (pipe == 'J') {
                    facing = 'N';
                } else if (pipe == '7') {
                    facing = 'S';
                } else if (pipe == '|') {
                    facing = 'S';
                }
                break;
            default:
                break;
        }

        return facing;
    }

    static int countLoop() {
        int steps = 0;
        int row = startRow;
        int col = startCol;
        char facing = setFacing('N', pipes[row][col]);
        boolean backToStart = false;
        while (!backToStart) {
            switch (facing) {
                case 'N':
                    row--;
                    break;
                case 'S':
                    row++;
                    break;
                case 'W':
                    col--;
                    break;
                case 'E':
                    col++;
                    break;
                default:
                    break;
            }
            steps++;
            if (col == startCol && row == startRow) {
                backToStart = true;
            }
            facing = setFacing(facing, pipes[row][col]);
        }
        return steps;
    }

    public static void main(String[] args) {
        String lines = ReadFile.readFromFile("src/year2023/day10/input.txt");
        processLines(lines);
        setStart();
        System.out.println(countLoop() / 2);
    }

    static <T> void print2Darray(T[][] array) {
        for (T[] row : array) {
            for (T element : row) {
                if (element == null) {
                    System.out.print(". ");
                } else
                    System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    static void setStart() {
        char lowerNeighbour = pipes[startRow + 1][startCol];
        char upperNeighbour = pipes[startRow - 1][startCol];
        char leftNeighbour = pipes[startRow][startCol - 1];
        char rightNeighbour = pipes[startRow][startCol + 1];

        switch (lowerNeighbour) {
            case '|':
            case 'J':
            case 'L':
                if (leftNeighbour == '-' || leftNeighbour == 'L' || leftNeighbour == 'F') {
                    pipes[startRow][startCol] = '7';
                } else if (rightNeighbour == '-' || rightNeighbour == '7' || rightNeighbour == 'J') {
                    pipes[startRow][startCol] = 'F';
                } else if (upperNeighbour == '|' || upperNeighbour == 'F' || upperNeighbour == '7') {
                    pipes[startRow][startCol] = '|';
                }
                break;
            default:
                break;
        }

        switch (upperNeighbour) {
            case '|':
            case 'F':
            case '7':
                if (leftNeighbour == '-' || leftNeighbour == 'L' || leftNeighbour == 'F') {
                    pipes[startRow][startCol] = 'J';
                } else if (rightNeighbour == '-' || rightNeighbour == '7' || rightNeighbour == 'J') {
                    pipes[startRow][startCol] = 'L';
                } else if (lowerNeighbour == '|' || lowerNeighbour == 'J' || lowerNeighbour == 'L') {
                    pipes[startRow][startCol] = '|';
                }
                break;
            default:
                break;
        }

        switch (rightNeighbour) {
            case '-':
            case 'J':
            case '7':
                if (upperNeighbour == '7' || upperNeighbour == '|' || upperNeighbour == 'F') {
                    pipes[startRow][startCol] = 'L';
                } else if (lowerNeighbour == '|' || lowerNeighbour == 'J' || lowerNeighbour == 'L') {
                    pipes[startRow][startCol] = 'F';
                } else if (leftNeighbour == '-' || leftNeighbour == 'F' || leftNeighbour == 'L') {
                    pipes[startRow][startCol] = '-';
                }
            default:
                break;
        }

        switch (leftNeighbour) {
            case '-':
            case 'L':
            case 'F':
                if (upperNeighbour == '7' || upperNeighbour == '|' || upperNeighbour == 'F') {
                    pipes[startRow][startCol] = 'J';
                } else if (lowerNeighbour == '|' || lowerNeighbour == 'J' || lowerNeighbour == 'L') {
                    pipes[startRow][startCol] = '7';
                } else if (rightNeighbour == '-' || rightNeighbour == '7' || rightNeighbour == 'J') {
                    pipes[startRow][startCol] = '-';
                }
            default:
                break;
        }
    }
}
