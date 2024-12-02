package year2015.day18;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Graphics2D;

public class Day18 {
    static Light[][] lights;

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2015/day18/input.txt");
        lights = new Light[100][100];
        processLines(lines);
        for (int i = 0; i < 100; i++) {
            // BufferedImage image = createImage(lights.length);
            // saveImage(image, "year2015/day18/output/" + i + ".png");
            calcNextLight();
        }
        // createGif("year2015/day18/output.gif", "year2015/day18/output/", 100);
        System.out.println("Number of on: " + countOn());
    }

    static void processLines(String lines) {
        int row = 0;
        for (String line : lines.split("\n")) {
            char[] lineChars = line.toCharArray();
            for (int col = 0; col < lineChars.length; col++) {
                Light light = new Light(row, col, lineChars[col]);
                lights[row][col] = light;
            }
            row++;
        }
    }

    static void printLights(Light[][] lights) {
        for (Light[] row : lights) {
            for (Light c : row) {
                System.out.print(c.value);
            }
            System.out.println();
        }
    }

    static void calcNextLight() {
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                int onNeighbours = checkNeighbours(row, col);
                Light light = lights[row][col];
                if (light.value == '#') {
                    if (onNeighbours == 2 || onNeighbours == 3) {
                        light.nextValue = '#';
                    } else {
                        light.nextValue = '.';
                    }
                } else {
                    if (onNeighbours == 3) {
                        light.nextValue = '#';
                    } else {
                        light.nextValue = '.';
                    }
                }
                if(row == 0 && col == 0 || row == 0 && col == 99 || row == 99 && col == 0 || row == 99 && col == 99) {
                    light.nextValue = '#';
                }
            }
        }
        changeToNext();
    }

    static void changeToNext() {
        for (int row = 0; row < lights.length; row++) {
            for (int col = 0; col < lights[row].length; col++) {
                Light light = lights[row][col];
                light.value = light.nextValue;
            }
        }
    }

    static int checkNeighbours(int row, int col) {
        int[][] neighbors = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };
        int onNeighbours = 0;
        for (int[] neighbor : neighbors) {
            int newRow = row + neighbor[0];
            int newCol = col + neighbor[1];
            if (newRow >= 0 && newRow < lights.length && newCol >= 0 && newCol < lights[0].length) {
                Light light = lights[newRow][newCol];
                if (light.value == '#') {
                    onNeighbours++;
                }
            }
        }
        return onNeighbours;
    }

    static int countOn() {
        int on = 0;
        for (Light[] row : lights) {
            for (Light light : row) {
                if (light.value == '#') {
                    on++;
                }
            }
        }
        return on;
    }

    private static BufferedImage createImage(int gridSize) {
        int newWidth = 800; 
        int newHeight = 800;
        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (lights[i][j].value == '#') {
                    g.setColor(Color.BLACK); 
                } else {
                    g.setColor(Color.WHITE); 
                }

                int x = i * (newWidth / gridSize);
                int y = j * (newHeight / gridSize);

                g.fillRect(x, y, newWidth / gridSize, newHeight / gridSize);
            }
        }

        g.dispose();

        return image;

    }

    private static void saveImage(BufferedImage image, String fileName) {
        try {
            ImageIO.write(image, "PNG", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createGif(String outputFileName, String baseFileName, int iterations) {
        try {
            ImageOutputStream output = new FileImageOutputStream(new File(outputFileName));
            GifSequenceWriter writer = new GifSequenceWriter(output, BufferedImage.TYPE_INT_RGB, 100, true);

            for (int i = 0; i < iterations; i++) {
                BufferedImage image = ImageIO.read(new File(baseFileName + i + ".png"));
                writer.writeToSequence(image);
            }

            writer.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
