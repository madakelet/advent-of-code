package year2023.day7;

import java.util.HashMap;
import java.util.Map;

public class Hand implements Comparable<Hand> {
    String cards;
    int bid;
    HandType handType;

    public Hand(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;
        setHandType();
    }

    public void setHandType() {
        Map<Character, Integer> cardCountMap = getCardCount();
        HandType handType = HandType.HIGH_CARD;
        for (int count : cardCountMap.values()) {
            if (count == 5) {
                handType = HandType.FIVE_OF_A_KIND;
            } else if (count == 4) {
                handType = HandType.FOUR_OF_A_KIND;
            } else if (count == 3) {
                if (handType == HandType.ONE_PAIR) {
                    handType = HandType.FULL_HOUSE;
                } else {
                    handType = HandType.THREE_OF_A_KIND;
                }
            } else if (count == 2) {
                if (handType == HandType.THREE_OF_A_KIND) {
                    handType = HandType.FULL_HOUSE;
                } else if (handType == HandType.ONE_PAIR) {
                    handType = HandType.TWO_PAIRS;
                } else {
                    handType = HandType.ONE_PAIR;
                }
            }
        }

        this.handType = handType;
    }

    public Map<Character, Integer> getCardCount() {
        Map<Character, Integer> cardCountMap = new HashMap<>();
        for (char c : cards.toCharArray()) {
            cardCountMap.put(c, cardCountMap.getOrDefault(c, 0) + 1);
        }
        return cardCountMap;
    }

    @Override
    public int compareTo(Hand other) {
        if (handType.ordinal() > other.handType.ordinal()) {
            return 1;
        } else if (handType.ordinal() < other.handType.ordinal()) {
            return -1;
        } else {
            Map<Character, Integer> rankings = new HashMap<>();
            rankings.put('2', 1);
            rankings.put('3', 2);
            rankings.put('4', 3);
            rankings.put('5', 4);
            rankings.put('6', 5);
            rankings.put('7', 6);
            rankings.put('8', 7);
            rankings.put('9', 8);
            rankings.put('T', 9);
            rankings.put('J', 10);
            rankings.put('Q', 11);
            rankings.put('K', 12);
            rankings.put('A', 13);

            for (int i = 0; i < cards.length(); i++) {
                int thisRank = rankings.get(cards.charAt(i));
                int otherRank = rankings.get(other.cards.charAt(i));

                if (thisRank > otherRank) {
                    return 1;
                } else if (thisRank < otherRank) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
