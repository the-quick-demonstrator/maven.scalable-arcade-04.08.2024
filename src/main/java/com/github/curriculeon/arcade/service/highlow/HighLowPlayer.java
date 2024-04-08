package com.github.curriculeon.arcade.service.highlow;

import com.github.curriculeon.arcade.lib.game.cardgame.AbstractCardGamePlayer;
import com.github.curriculeon.arcade.lib.game.cardgame.utils.card.CardInterface;
import com.github.curriculeon.arcade.lib.profile.ProfileInterface;

/**
 * Created by leon on 6/24/2020.
 */
public class HighLowPlayer extends AbstractCardGamePlayer {
    enum DecisionState {
        HIGH,LOW,BLUFF;
    }
    private DecisionState decision;
    private int numberOfPoints;

    public HighLowPlayer(final ProfileInterface profile) {
        super(profile);
    }

    @Override
    public void removeCard(final CardInterface card) {
        super.removeCard(card);
        increasePoints(1);
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void increasePoints(final int numberOfPointsToIncreaseBy) {
        this.numberOfPoints = getNumberOfPoints()+numberOfPointsToIncreaseBy;
    }

    public void decreasePoints(final int numberOfPointsToDecreaseBy) {
        increasePoints(-numberOfPointsToDecreaseBy);
    }

    public void setDecision(final DecisionState decision) {
        this.decision = decision;
    }

    public DecisionState getDecision() {
        return decision;
    }

    public CardInterface getCard() {
        return getHand().get(0);
    }
}
