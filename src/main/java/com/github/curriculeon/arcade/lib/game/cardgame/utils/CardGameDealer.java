package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.github.curriculeon.arcade.lib.game.cardgame.AbstractCardGamePlayer;
import com.github.curriculeon.arcade.lib.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

/**
 * Created by leon on 6/27/2020.
 */
public class CardGameDealer extends AbstractCardGamePlayer {
    private Deck deck;

    public CardGameDealer(ProfileInterface profile, Deck deck) {
        super(profile);
        this.deck = deck;
    }

    public void shuffle() {
        deck.shuffle();
    }

    public CardInterface deal(CardGamePlayerInterface cardGamePlayer) {
        CardInterface card = deck.pop();
        cardGamePlayer.addCard(card);
        return card;
    }
}
