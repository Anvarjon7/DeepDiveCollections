package org.example.objectOrientedDesign.dSForAGenericDeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    protected List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()){
                cards.add(new Card(suit,rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){
        if (cards.isEmpty()) return null;
        return cards.remove(cards.size() - 1);
    }

    public int size(){
        return cards.size();
    }
}
