package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.curriculeon.arcade.lib.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.utils.Pair;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by leon on 6/26/2020.
 */
public class DiscardPile<CardGamePlayerType extends CardGamePlayerInterface> {
    private Stack<Pair<CardGamePlayerType, CardInterface>> cardMap;

    public DiscardPile() {
        this.cardMap = new Stack<>();
    }

    public void add(CardGamePlayerType player, CardInterface card) {
        cardMap.push(new Pair<>(player, card));
        player.getHand().remove(card);
    }

    public List<CardInterface> getAllCards() {
        return cardMap
                .stream()
                .map(Pair::getValue)
                .collect(Collectors.toList());
    }

    public List<CardInterface> getAllCardsDiscardedByPlayer(CardGamePlayerType player) {
        return cardMap
                .stream()
                .filter(pair -> pair.getKey().equals(player))
                .map(Pair::getValue)
                .collect(Collectors.toList());
    }

    public Pair<CardGamePlayerType, CardInterface> getPlayerAndCardAtIndex(int index) {
        return cardMap.get(index);
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
