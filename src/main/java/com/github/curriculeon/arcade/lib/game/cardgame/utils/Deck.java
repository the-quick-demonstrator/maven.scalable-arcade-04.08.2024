package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.Card;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.Rank;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.Suit;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by leon.hunter on 2/1/2017.
 */

public class Deck implements Iterable<Card> {
    private Stack<CardInterface> cardStack = new Stack<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                cardStack.push(card);
            }
        }
    }

    public CardInterface pop() {
        return cardStack.pop();
    }

    public CardInterface push(CardInterface card) {
        return cardStack.push(card);
    }

    public CardInterface peek() {
        return cardStack.peek();
    }

    public boolean isEmpty() {
        return cardStack.isEmpty();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    @Override
    public Iterator iterator() {
        return cardStack.iterator();
    }

    public int size() {
        return cardStack.size();
    }
}