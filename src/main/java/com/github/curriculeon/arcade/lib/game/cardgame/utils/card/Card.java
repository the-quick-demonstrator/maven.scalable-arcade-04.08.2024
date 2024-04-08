package com.github.curriculeon.arcade.lib.game.cardgame.utils.card;

/**
 * Created by leon.hunter on 2/1/2017.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */

public class Card implements CardInterface {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return rank.getValue();
    }

    public String toString() {
        return rank.name() + " of " + suit.name();
    }
}