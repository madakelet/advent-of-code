package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day2.Game;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("day4/input.txt"));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                Card card = new Card(line);
                sum += card.getPowerOfTwo();
            }
            reader.close();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}