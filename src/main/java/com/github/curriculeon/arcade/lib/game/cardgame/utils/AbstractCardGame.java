package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.github.curriculeon.arcade.lib.game.cardgame.CardGamePlayerInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 6/26/2020.
 */
abstract public class AbstractCardGame<
        CardGamePlayerType extends CardGamePlayerInterface>
        implements CardGameInterface<CardGamePlayerType> {

    private DiscardPile<CardGamePlayerType> discardPile;
    private List<CardGamePlayerType> players;
    private Deck deck;


    public AbstractCardGame(List<CardGamePlayerType> players, DiscardPile<CardGamePlayerType> discardPile, Deck deck) {
        this.deck = deck;
        this.discardPile = discardPile;
        this.players = players;
    }

    public AbstractCardGame() {
        this(new ArrayList<>(), new DiscardPile<>(), new Deck());
    }

    @Override
    public DiscardPile<CardGamePlayerType> getDiscardPile() {
        return discardPile;
    }

    @Override
    public List<CardGamePlayerType> getPlayers() {
        return players;
    }

    @Override
    public Deck getDeck() {
        return deck;
    }
}
