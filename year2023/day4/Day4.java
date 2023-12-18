package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Day4 {
    public static void main(String[] args) {
        String[] lines = readInputFromFile("year2023/day4/test.txt");
        List<Card> cards = new ArrayList<>();
        int sum = 0;
        for (String cardLine : lines) {
            Card card = new Card(cardLine);
            cards.add(card);
            sum += card.getPowerOfTwo();
        }
        
        ListIterator<Card> it = cards.listIterator();
        while(it.hasNext()) {
            Card card = it.next();
            double winnings = card.getWinningNumbers();
            for(int i = card.getCardNr() + 1; i < card.getCardNr() + winnings; i++) {
                Card otherCard = cards.get(i);
                Card newCard = otherCard.clone();
                it.add(newCard);
            }
            System.out.println(card.getCardNr());
        }
        System.out.println("Sum: " + sum);
    }

    private static String[] readInputFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}