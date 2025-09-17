package org.example.objectOrientedDesign.dSForAGenericDeckOfCards;

public class Card {

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    enum Suit{CLUBS,DIAMONDS,HEARTS,SPADES};
    enum Rank{ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE};

    private final Suit suit;
    private final Rank rank;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
