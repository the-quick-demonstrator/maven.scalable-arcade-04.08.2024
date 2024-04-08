package com.github.curriculeon.arcade.service.blackjack;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.AbstractCardGame;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileManager;
import com.github.curriculeon.arcade.service.highlow.HighLowPlayer;

import java.util.Collections;
import java.util.List;

public class BlackJackGame extends AbstractCardGame<BlackJackPlayer> {
    @Override
    public void run() {
        getDeck().shuffle();
        final BlackJackDealer dealer = new BlackJackDealer();
        dealer.deal(getDeck(), 1, dealer);
        dealer.deal(getDeck(), 2, getPlayers());
        dealer.deal(getDeck(), 1, dealer);

        final List<CardInterface> hand = dealer.getHand();
        final CardInterface card = hand.get(0);
        hand.remove(card);
        getDiscardPile().add(dealer, card);
    }


    @Override
    public void createPlayers() {
        final Integer numberOfPlayers = getConsole().getIntegerInput("How many players will be playing?");
        for (int i = 0; i < numberOfPlayers; i++) {
            final String infoMessage = "Player number [ %s ], enter your profile id.";
            final Long playerId = getConsole().getLongInput(infoMessage, i);
            final ProfileInterface profile = ProfileManager.INSTANCE.getProfileById(playerId);
            final BlackJackPlayer blackJackPlayer = new BlackJackPlayer(profile);
            addPlayer(blackJackPlayer);
        }
    }
}
