package com.github.curriculeon.arcade.lib.game.cardgame;

import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
abstract public class AbstractCardGamePlayer implements CardGamePlayerInterface {
    private ProfileInterface profile;
    private List<CardInterface> hand;

    public AbstractCardGamePlayer(ProfileInterface profile) {
        this.profile = profile;
        this.hand = new ArrayList<>();
    }

    @Override
    public ProfileInterface getProfile() {
        return this.profile;
    }

    @Override
    public List<CardInterface> getHand() {
        return this.hand;
    }

    @Override
    public void setHand(List<CardInterface> cardList) {
        if(cardList.size()>1) {
            throw new IllegalArgumentException("A HighLowPlayer's hand cannot exceed a size of `1`");
        }
        this.hand = cardList;
    }
}
