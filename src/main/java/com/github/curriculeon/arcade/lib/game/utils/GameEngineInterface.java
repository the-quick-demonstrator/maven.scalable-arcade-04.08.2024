package com.github.curriculeon.arcade.lib.game.utils;

import com.github.curriculeon.arcade.lib.game.PlayerInterface;

/**
 * Created by leon on 2/25/18.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface GameEngineInterface<
        GameTypePlayer extends PlayerInterface,
        GameType extends GameInterface<GameTypePlayer>>
        extends Runnable {

    GameType getGame();

    void evaluateTurn(GameTypePlayer player);

    default void setUp() {
        getGame().createPlayers();
        if(getGame().getPlayers().size() < 1) {
            String errorMessage = "Invalid number of players specified for game of [ %s ]";
            throw new IllegalArgumentException(String.format(errorMessage, getGame().getClass().getSimpleName()));
        }
    }

    default void run() {
        getGame().run();
        for(GameTypePlayer player : getGame().getPlayers()) {
            evaluateTurn(player);
        }
    }
}
