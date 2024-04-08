package com.github.curriculeon.arcade.service.blackjack;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.Deck;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.Profile;

import java.util.Arrays;
import java.util.List;

public class BlackJackDealer extends BlackJackPlayer {
    public BlackJackDealer() {
        super(new Profile("DEALER", Double.MAX_VALUE, null));
    }

    public void deal(Deck deck, int numberOfCards, BlackJackPlayer... players) {
        deal(deck, numberOfCards, Arrays.asList(players));
    }

    public void deal(Deck deck, int numberOfCards, List<BlackJackPlayer> players) {
        for (int i = 0; i < numberOfCards; i++) {
            for (final BlackJackPlayer player : players) {
                final CardInterface card = deck.pop();
                player.addCard(card);
            }
        }
    }
}