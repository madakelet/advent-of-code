package year2023.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Day7 {

    public static List<Hand> hands;

    public static void main(String[] args) {
        long sum = 0;
        hands = new ArrayList<>();
        createHansArrayFromInput("year2023/day7/input.txt");
        Collections.sort(hands);
        int ranking = 1;
        for (Hand hand : hands) {
            sum += hand.bid * ranking;
            ranking++;
        }
        System.out.println("Sum of all bids: " + sum);
    }

    public static void createHansArrayFromInput(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                int bid = Integer.parseInt(values[1]);
                String cards = values[0];
                Hand hand = new Hand(cards, bid);
                hands.add(hand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}