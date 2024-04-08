package com.github.curriculeon.arcade.lib.game.cardgame.utils;

import com.github.curriculeon.arcade.lib.game.cardgame.CardGamePlayerInterface;
import com.github.curriculeon.arcade.lib.game.utils.GameInterface;

public interface CardGameInterface<
        CardGamePlayerType extends CardGamePlayerInterface>
        extends GameInterface<CardGamePlayerType> {
    DiscardPile getDiscardPile();

    Deck getDeck();
}
