package com.github.curriculeon.arcade.service.blackjack;

import com.github.curriculeon.arcade.lib.game.cardgame.AbstractCardGamePlayer;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

public class BlackJackPlayer extends AbstractCardGamePlayer {
    enum DecisionState {
        HIT,STAY,SPLIT,DOUBLE,CONCEDE;
    }

    public BlackJackPlayer(ProfileInterface profile) {
        super(profile);
    }

    public int getHandValue() {
        int finalValue = 0;
        for(CardInterface card : getHand()) {
            finalValue += card.getValue();
        }
        return finalValue;
    }
}