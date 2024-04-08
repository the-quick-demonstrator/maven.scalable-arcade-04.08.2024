package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.Rank;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 10/27/17.
 */
public class TestCardDeck {
    Deck cardDeck = new Deck();

    @Test
    public void testRank() {
        List<Rank> allRanks = Arrays.asList(Rank.values());
        List<Rank> deckRanks = new ArrayList<>();
        cardDeck.forEach(card-> deckRanks.add(card.getRank()));
        allRanks.forEach(rank -> Assert.assertTrue(deckRanks.contains(rank)));
    }

    @Test
    public void testSuit() {
        List<Suit> allSuits = Arrays.asList(Suit.values());
        List<Suit> deckSuits = new ArrayList<>();
        cardDeck.forEach(card-> deckSuits.add(card.getSuit()));
        allSuits.forEach(rank -> Assert.assertTrue(deckSuits.contains(rank)));
    }
}
