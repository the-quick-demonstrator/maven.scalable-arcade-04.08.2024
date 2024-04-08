package com.github.curriculeon.arcade.service.blackjack;

import com.github.curriculeon.arcade.lib.game.utils.GameDecisionInterface;

import java.util.function.BiConsumer;

import static com.github.curriculeon.arcade.lib.utils.InputOutputConsole.IO_CONSOLE;

public enum BlackJackGameDecision implements GameDecisionInterface<BlackJackGame, BlackJackPlayer>  {
    VIEW_DISCARD_PILE((game, player) -> {
        IO_CONSOLE.println("Discard Pile is being displayed...");
        IO_CONSOLE.println(game.getDiscardPile().toString());
    }),

    VIEW_HAND((game, player) -> {
        IO_CONSOLE.println("Player %s is displaying their hand...", player.getName());
        IO_CONSOLE.println(player.getHand().toString());
    });

    private BiConsumer<BlackJackGame, BlackJackPlayer> procedure;

    BlackJackGameDecision(BiConsumer<BlackJackGame, BlackJackPlayer> procedure) {
        this.procedure = procedure;
    }

    @Override
    public BiConsumer<BlackJackGame, BlackJackPlayer> getProcedure() {
        return null;
    }
}
