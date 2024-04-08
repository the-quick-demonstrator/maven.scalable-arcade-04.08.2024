package com.github.curriculeon.arcade.lib.game.cardgame.utils.card;

/**
 * Created by leon.hunter on 2/1/2017.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public enum Suit implements SuitInterface {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private String cardGraphic;

    Suit(String cardGraphic) {
        this.cardGraphic = cardGraphic;
    }

    public String getCardGraphic() {
        return cardGraphic;
    }
}
