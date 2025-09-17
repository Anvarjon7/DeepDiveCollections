package org.example.objectOrientedDesign.dSForAGenericDeckOfCards;

public class BlackjackCard extends Card {

    public BlackjackCard(Suit suit, Rank rank) {
        super(suit, rank);
    }

    public int getValue() {
        return switch (getRank()) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, JACK, QUEEN, KING -> 10;
            case ACE -> 11;
        };
    }

}
