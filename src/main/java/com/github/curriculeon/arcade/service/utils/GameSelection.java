package com.github.curriculeon.arcade.service.utils;


import com.github.curriculeon.arcade.lib.game.utils.GameEngineInterface;
import com.github.curriculeon.arcade.service.blackjack.BlackJackGameEngine;
import com.github.curriculeon.arcade.service.highlow.HighLowGameEngine;
import com.github.curriculeon.arcade.lib.utils.DecisionInterface;

import java.util.function.Supplier;

/**
 * Created by leon on 2/25/18.
 */
public enum GameSelection implements DecisionInterface {
    HIGH_LOW(HighLowGameEngine::new),
    BLACKJACK(()-> (GameEngineInterface)new BlackJackGameEngine());

    private final Supplier<GameEngineInterface<?,?>> gameConstructor;

    GameSelection(Supplier<GameEngineInterface<?,?>> gameConstructor) {
        this.gameConstructor = gameConstructor;
    }

    public void perform() {
        GameEngineInterface<?, ?> gameEngine = create();
        gameEngine.setUp();
        gameEngine.run();
    }

    public GameEngineInterface<?,?> create() {
        return gameConstructor.get();
    }
}
