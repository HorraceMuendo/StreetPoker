import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandRankings {
    public static int getHandRank(List<Card> hand) {
        if (isRoyalFlush(hand)) {
            return 9;
        } else if (isStraightFlush(hand)) {
            return 8;
        } else if (isFourOfAKind(hand)) {
            return 7;
        } else if (isFullHouse(hand)) {
            return 6;
        } else if (isFlush(hand)) {
            return 5;
        } else if (isStraight(hand)) {
            return 4;
        } else if (isThreeOfAKind(hand)) {
            return 3;
        } else if (isTwoPair(hand)) {
            return 2;
        } else if (isOnePair(hand)) {
            return 1;
        } else {
            return 0; // High Card
        }
    }

    private static boolean isRoyalFlush(List<Card> hand) {
        return isStraightFlush(hand) && hasAce(hand);
    }

    private static boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private static boolean isFourOfAKind(List<Card> hand) {
        Map<Rank, Integer> rankCounts = getRankCounts(hand);
        return rankCounts.containsValue(4);
    }

    private static boolean isFullHouse(List<Card> hand) {
        Map<Rank, Integer> rankCounts = getRankCounts(hand);
        return rankCounts.containsValue(3) && rankCounts.containsValue(2);
    }

    private static boolean isFlush(List<Card> hand) {
        Suit suit = hand.get(0).getSuit();
        return hand.stream().allMatch(card -> card.getSuit() == suit);
    }

    private static boolean isStraight(List<Card> hand) {
        List<Rank> ranks = hand.stream().map(Card::getRank).collect(Collectors.toList());
        Collections.sort(ranks);
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i).ordinal() + 1 != ranks.get(i + 1).ordinal()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeOfAKind(List<Card> hand) {
        Map<Rank, Integer> rankCounts = getRankCounts(hand);
        return rankCounts.containsValue(3);
    }

    private static boolean isTwoPair(List<Card> hand) {
        Map<Rank, Integer> rankCounts = getRankCounts(hand);
        int pairCount = 0;
        for (Integer count : rankCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private static boolean isOnePair(List<Card> hand) {
        Map<Rank, Integer> rankCounts = getRankCounts(hand);
        return rankCounts.containsValue(2);
    }

    private static boolean hasAce(List<Card> hand) {
        return hand.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

    private static Map<Rank, Integer> getRankCounts(List<Card> hand) {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Card card : hand) {
            Rank rank = card.getRank();
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }
}
